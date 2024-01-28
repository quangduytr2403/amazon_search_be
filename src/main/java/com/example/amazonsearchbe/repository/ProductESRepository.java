package com.example.amazonsearchbe.repository;

import com.example.amazonsearchbe.entity.ProductES;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductESRepository {
    List<ProductES> findProductWithFilterEs(String searchKey, List<UUID> categories, List<UUID> brands, BigDecimal rating,
                                            BigDecimal min, BigDecimal max, String orderBy, Sort.Direction orderDirection);
}
