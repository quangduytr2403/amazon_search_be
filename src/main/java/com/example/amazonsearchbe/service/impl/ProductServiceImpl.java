package com.example.amazonsearchbe.service.impl;

import com.example.amazonsearchbe.dto.BrandDto;
import com.example.amazonsearchbe.dto.CategoryDto;
import com.example.amazonsearchbe.dto.ProductDto;
import com.example.amazonsearchbe.dto.SellerDto;
import com.example.amazonsearchbe.entity.Category;
import com.example.amazonsearchbe.entity.Product;
import com.example.amazonsearchbe.model.Pagination;
import com.example.amazonsearchbe.repository.CategoryRepository;
import com.example.amazonsearchbe.repository.ProductRepository;
import com.example.amazonsearchbe.service.BrandService;
import com.example.amazonsearchbe.service.CategoryProductService;
import com.example.amazonsearchbe.service.ProductService;
import com.example.amazonsearchbe.service.SellerService;
import com.example.amazonsearchbe.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandService brandService;
    private final SellerService sellerService;
    private final CategoryProductService categoryProductService;

    @Override
    public Pagination<ProductDto> findProductWithFilter(int pageIndex, int pageSize, String searchKey, List<UUID> categories,
                                                        List<UUID> brands, Integer rating, Integer min, Integer max,
                                                        String orderBy, Sort.Direction orderDirection) {
        Set<UUID> childCategories = new HashSet<>();

        for (UUID categoryId : categories) {
            Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
            if (categoryOptional.isPresent()) {
                if (categoryOptional.get().isHasChildren()) {
                    childCategories.addAll(categoryRepository.findAllByHasChildrenAndParentId(false, categories.get(0))
                            .stream().map(Category::getId).toList());
                } else {
                    childCategories.add(categoryId);
                }
            }
        }

        if (CollectionUtils.isEmpty(brands)) {
            brands = null;
        }

        Pageable pageable = PageRequest.of(pageIndex, pageSize, Sort.by(orderDirection, orderBy).and(Sort.by("id")));
        Page<Product> productPage = productRepository.findProductWithFilter(
                searchKey, CollectionUtils.isEmpty(childCategories) ? null : childCategories.stream().toList(),
                brands, Objects.isNull(rating) ? null : BigDecimal.valueOf(rating), Objects.isNull(min) ? null : BigDecimal.valueOf(min),
                Objects.isNull(max) ? null : BigDecimal.valueOf(max), pageable);
        List<Product> products = productPage.getContent();

        List<ProductDto> productDtos = products.stream().map(product -> {
            BrandDto brandDto = brandService.findBrandById(product.getBrandId());
            SellerDto sellerDto = sellerService.findSellerById(product.getSellerId());
            List<CategoryDto> categoryDtos = categoryProductService.findCategoriesByProductId(product.getId());

            return ProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .originalPrice(product.getOriginalPrice())
                    .salePrice(product.getSalePrice())
                    .brand(brandDto)
                    .seller(sellerDto)
                    .image(product.getImage())
                    .isNew(product.isNew())
                    .rating(product.getRating())
                    .sold(product.getSold())
                    .categories(categoryDtos)
                    .createdAt(TimeUtils.convertLocalDateTimeToEpochMilli(product.getCreatedAt()))
                    .updatedAt(TimeUtils.convertLocalDateTimeToEpochMilli(product.getUpdatedAt()))
                    .deleted(product.isDeleted())
                    .build();
        }).toList();

        return Pagination.create(productDtos, pageIndex, pageSize, productPage.getTotalElements());
    }
}
