package com.example.amazonsearchbe.service;

import com.example.amazonsearchbe.dto.BrandDto;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    BrandDto findBrandById(UUID id);

    List<BrandDto> findBrandLinkWithProduct(String searchKey, List<UUID> categories);
}
