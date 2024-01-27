package com.example.amazonsearchbe.service.impl;

import com.example.amazonsearchbe.dto.CategoryDto;
import com.example.amazonsearchbe.entity.Category;
import com.example.amazonsearchbe.repository.CategoryRepository;
import com.example.amazonsearchbe.service.CategoryService;
import com.example.amazonsearchbe.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAllParentCategories() {
        return categoryRepository.findAllByHasChildren(true).stream().map(
                category -> CategoryDto.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .createdAt(TimeUtils.convertLocalDateTimeToEpochMilli(category.getCreatedAt()))
                        .updatedAt(TimeUtils.convertLocalDateTimeToEpochMilli(category.getUpdatedAt()))
                        .deleted(category.isDeleted())
                        .build()
        ).toList(
        );
    }

    @Override
    public List<CategoryDto> findAllChildCategoryOfParent(UUID parentId) {
        List<Category> categories;
        if (Objects.isNull(parentId)) {
            categories = categoryRepository.findAllByHasChildren(false);
        } else {
            categories = categoryRepository.findAllByHasChildrenAndParentId(false, parentId);
        }

        return categories.stream().map(
                category -> CategoryDto.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .createdAt(TimeUtils.convertLocalDateTimeToEpochMilli(category.getCreatedAt()))
                        .updatedAt(TimeUtils.convertLocalDateTimeToEpochMilli(category.getUpdatedAt()))
                        .deleted(category.isDeleted())
                        .build()
        ).toList();
    }
}
