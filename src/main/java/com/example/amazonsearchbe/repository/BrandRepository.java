package com.example.amazonsearchbe.repository;

import com.example.amazonsearchbe.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {

    @Query(value = """
            	SELECT DISTINCT b from Product p
            	JOIN Brand b ON p.brandId = b.id
            	JOIN CategoryProduct cp ON p.id = cp.productId
                WHERE LOWER(p.name) LIKE LOWER(:#{'%'+ #searchKey + '%'})
                    AND (COALESCE(:categories, NULL) IS NULL OR cp.categoryId IN (:categories))
            """)
    List<Brand> findBrandLinkWithProduct(String searchKey, List<UUID> categories);
}
