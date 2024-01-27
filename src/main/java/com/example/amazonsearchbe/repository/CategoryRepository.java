package com.example.amazonsearchbe.repository;

import com.example.amazonsearchbe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    List<Category> findAllByHasChildren(boolean hasChildren);

    List<Category> findAllByHasChildrenAndParentId(boolean hasChildren, UUID parentId);
}
