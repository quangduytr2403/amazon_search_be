package com.example.amazonsearchbe.repository;

import com.example.amazonsearchbe.entity.Category;
import com.example.amazonsearchbe.entity.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, UUID> {

    @Query(value = """
            	SELECT c from Product p
            	JOIN CategoryProduct cp ON p.id = cp.productId
            	JOIN Category c ON cp.categoryId = c.id
                WHERE p.id = :id
            """)
    List<Category> findCategoryByProductId(UUID id);

    @Query(value = """
            	SELECT DISTINCT cp.productId from CategoryProduct cp
                WHERE cp.categoryId IN :categoryIds
            """)
    List<UUID> findProductIdByCategoryIdIn(List<UUID> categoryIds);
}
