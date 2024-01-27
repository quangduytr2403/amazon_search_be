package com.example.amazonsearchbe.service;

import com.example.amazonsearchbe.dto.CategoryDto;

import java.util.List;
import java.util.UUID;

public interface CategoryProductService {
    List<CategoryDto> findCategoriesByProductId(UUID id);
}
