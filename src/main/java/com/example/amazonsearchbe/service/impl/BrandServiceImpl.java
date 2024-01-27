package com.example.amazonsearchbe.service.impl;

import com.example.amazonsearchbe.dto.BrandDto;
import com.example.amazonsearchbe.entity.Category;
import com.example.amazonsearchbe.repository.BrandRepository;
import com.example.amazonsearchbe.repository.CategoryRepository;
import com.example.amazonsearchbe.service.BrandService;
import com.example.amazonsearchbe.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public BrandDto findBrandById(UUID id) {
        return brandRepository.findById(id).map(brand ->
                        BrandDto.builder()
                                .id(brand.getId())
                                .name(brand.getName())
                                .description(brand.getDescription())
                                .logo(brand.getLogo())
                                .createdAt(TimeUtils.convertLocalDateTimeToEpochMilli(brand.getCreatedAt()))
                                .updatedAt(TimeUtils.convertLocalDateTimeToEpochMilli(brand.getUpdatedAt()))
                                .deleted(brand.isDeleted())
                                .build())
                .orElse(null);
    }

    public List<BrandDto> findBrandLinkWithProduct(String searchKey, List<UUID> categories) {
        Set<UUID> childCategories = new HashSet<>();

        for (UUID categoryId : categories) {
            Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
            if (categoryOptional.isPresent()) {
                if (categoryOptional.get().isHasChildren()) {
                    childCategories.addAll(categoryRepository.findAllByHasChildrenAndParentId(false, categories.get(0))
                            .stream().map(Category::getId).toList());
                } else {
                    childCategories.add(categoryId);
                }
            }
        }

        return brandRepository.findBrandLinkWithProduct(
                        searchKey, CollectionUtils.isEmpty(childCategories) ? null : childCategories.stream().toList()).stream().map(brand ->
                        BrandDto.builder()
                                .id(brand.getId())
                                .name(brand.getName())
                                .description(brand.getDescription())
                                .logo(brand.getLogo())
                                .createdAt(TimeUtils.convertLocalDateTimeToEpochMilli(brand.getCreatedAt()))
                                .updatedAt(TimeUtils.convertLocalDateTimeToEpochMilli(brand.getUpdatedAt()))
                                .deleted(brand.isDeleted())
                                .build())
                .toList();
    }
}
