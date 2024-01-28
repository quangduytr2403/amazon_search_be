package com.example.amazonsearchbe.repository;

import com.example.amazonsearchbe.entity.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {

    @Query(value = """
            	SELECT s from Seller s
                    JOIN Product p ON p.sellerId = s.id
                    JOIN CategoryProduct cp ON p.id = cp.productId
                    JOIN Category c ON cp.categoryId = c.id
                WHERE LOWER(p.name) LIKE LOWER(:#{'%'+ #searchKey + '%'})
            	    AND (COALESCE(:category, NULL) IS NULL OR c.parentId = (:category))
            	GROUP BY s.id
            	ORDER BY COUNT(p.id) DESC
            """)
    Page<Seller> findSellerWithFilter(String searchKey, UUID category, Pageable pageable);
}
