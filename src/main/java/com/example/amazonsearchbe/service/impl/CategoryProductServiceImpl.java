package com.example.amazonsearchbe.service.impl;

import com.example.amazonsearchbe.dto.CategoryDto;
import com.example.amazonsearchbe.repository.CategoryProductRepository;
import com.example.amazonsearchbe.service.CategoryProductService;
import com.example.amazonsearchbe.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryProductServiceImpl implements CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;

    @Override
    public List<CategoryDto> findCategoriesByProductId(UUID id) {
        return categoryProductRepository.findCategoryByProductId(id).stream().map(
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
}
