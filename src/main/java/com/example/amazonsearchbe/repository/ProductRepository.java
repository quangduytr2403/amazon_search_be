package com.example.amazonsearchbe.repository;

import com.example.amazonsearchbe.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value = """
            	SELECT p from Product p
            	JOIN Brand b ON p.brandId = b.id
            	JOIN CategoryProduct cp ON p.id = cp.productId
                WHERE LOWER(p.name) LIKE LOWER(:#{'%'+ #searchKey + '%'})
                    AND (COALESCE(:categories, NULL) IS NULL OR cp.categoryId IN (:categories))
                    AND (COALESCE(:brands, NULL) IS NULL OR p.brandId IN (:brands))
                    AND (COALESCE(:rating, NULL) IS NULL OR p.rating >= (:rating))
                    AND (COALESCE(:min, NULL) IS NULL OR p.salePrice >= (:min))
                    AND (COALESCE(:max, NULL) IS NULL OR p.salePrice <= (:max))
            """)
    Page<Product> findProductWithFilter(String searchKey, List<UUID> categories, List<UUID> brands, BigDecimal rating,
                                        BigDecimal min, BigDecimal max, Pageable pageable);
}
