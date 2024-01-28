package com.example.amazonsearchbe.service;

import com.example.amazonsearchbe.dto.Pagination;
import com.example.amazonsearchbe.dto.ProductDto;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    Pagination<ProductDto> findProductWithFilter(int pageIndex, int pageSize, String searchKey, List<UUID> categories,
                                                 List<UUID> brands, Integer rating, Integer min, Integer max,
                                                 String orderBy, Sort.Direction orderDirection);

    Pagination<ProductDto> findProductWithFilterEs(int pageIndex, int pageSize, String searchKey, List<UUID> categories,
                                                   List<UUID> brands, Integer rating, Integer min, Integer max,
                                                   String orderBy, Sort.Direction orderDirection);
}
