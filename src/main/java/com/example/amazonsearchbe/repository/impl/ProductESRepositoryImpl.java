package com.example.amazonsearchbe.repository.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Operator;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import co.elastic.clients.json.JsonData;
import com.example.amazonsearchbe.entity.ProductES;
import com.example.amazonsearchbe.properties.ElasticSearchProperties;
import com.example.amazonsearchbe.repository.CategoryProductRepository;
import com.example.amazonsearchbe.repository.ProductESRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductESRepositoryImpl implements ProductESRepository {

    private final ElasticsearchClient elasticsearchClient;
    private final CategoryProductRepository categoryProductRepository;
    private final ElasticSearchProperties elasticSearchProperties;
    private static final String NAME_FIELD = "name";
    private static final String BRAND_ID_FIELD = "brandId";
    private static final String RATING_FIELD = "rating";
    private static final String PRICE_FIELD = "salePrice";

    @Override
    public List<ProductES> findProductWithFilterEs(String searchKey, List<UUID> categories, List<UUID> brands,
                                                   BigDecimal rating, BigDecimal min, BigDecimal max,
                                                   String orderBy, Sort.Direction orderDirection) {
        SearchRequest.Builder request = new SearchRequest.Builder()
                .index(elasticSearchProperties.getIndex().getProduct());

        BoolQuery.Builder boolQuery = new BoolQuery.Builder();
        List<Query> queries = new ArrayList<>();

        BoolQuery.Builder boolQueryName = new BoolQuery.Builder();
        Query queryName = buildMatchQuery(searchKey, NAME_FIELD, Operator.And);
        queries.add(boolQueryName.must(queryName).build()._toQuery());

        if (!CollectionUtils.isEmpty(brands)) {
            BoolQuery.Builder boolQueryBrand = new BoolQuery.Builder();
            List<Query> queriesBrands = new ArrayList<>();
            brands.forEach(brand -> queriesBrands.add(buildMatchQuery(brand.toString(), BRAND_ID_FIELD, Operator.Or)));
            queries.add(boolQueryBrand.should(queriesBrands).build()._toQuery());
        }

        if (Objects.nonNull(rating)) {
            BoolQuery.Builder boolQueryRating = new BoolQuery.Builder();
            Query queryRating = buildRangeQuery(rating, null, RATING_FIELD);
            queries.add(boolQueryRating.must(queryRating).build()._toQuery());
        }

        if (Objects.nonNull(min) || Objects.nonNull(max)) {
            BoolQuery.Builder boolQueryPrice = new BoolQuery.Builder();
            Query queryPrice = buildRangeQuery(min, max, PRICE_FIELD);
            queries.add(boolQueryPrice.must(queryPrice).build()._toQuery());
        }

        boolQuery.must(queries);
        request.query(boolQuery.build()._toQuery());

        List<SortOptions> sortOptionsList = new ArrayList<>();
        sortOptionsList.add(new SortOptions.Builder()
                .field(f -> f.field(orderBy)
                        .order(Sort.Direction.ASC.equals(orderDirection) ? SortOrder.Asc : SortOrder.Desc))
                .build());
        request.sort(sortOptionsList);

        List<ProductES> products = executeSearch(request.build(), ProductES.class);
        List<ProductES> filteredProducts = new ArrayList<>(products);

        if (!CollectionUtils.isEmpty(categories)) {
            List<UUID> matchedProductIds = categoryProductRepository.findProductIdByCategoryIdIn(categories);
            filteredProducts.removeIf(product -> !matchedProductIds.contains(product.getId()));
        }

        return filteredProducts;
    }

    private <T> List<T> executeSearch(SearchRequest searchRequest, Class<T> clazz) {
        try {
            SearchResponse<T> searchResponse = elasticsearchClient.search(searchRequest, clazz);

            List<Hit<T>> hits = Optional.ofNullable(searchResponse)
                    .map(SearchResponse::hits)
                    .map(HitsMetadata::hits)
                    .orElse(List.of());

            return hits.stream().map(Hit::source).filter(Objects::nonNull).toList();
        } catch (Exception e) {
            log.error("Error while search by ES: {}", e.getMessage());
        }
        return Collections.emptyList();
    }

    private Query buildMatchQuery(String value, String field, Operator operator) {
        MatchQuery.Builder matchQueryBuilder = new MatchQuery.Builder()
                .field(field)
                .query(value);
        if (Objects.nonNull(operator)) {
            matchQueryBuilder.operator(operator);
        }
        return matchQueryBuilder.build()
                ._toQuery();
    }

    private Query buildRangeQuery(BigDecimal minValue, BigDecimal maxValue, String field) {
        RangeQuery.Builder rangeQueryBuilder = new RangeQuery.Builder()
                .field(field);
        if (Objects.nonNull(minValue)) {
            rangeQueryBuilder.gte(JsonData.of(minValue));
        }
        if (Objects.nonNull(maxValue)) {
            rangeQueryBuilder.lte(JsonData.of(maxValue));
        }

        return rangeQueryBuilder.build()
                ._toQuery();
    }
}
