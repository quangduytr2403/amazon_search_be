package com.example.amazonsearchbe.service;

import com.example.amazonsearchbe.dto.Pagination;
import com.example.amazonsearchbe.dto.SellerDto;

import java.util.UUID;

public interface SellerService {
    SellerDto findSellerById(UUID id);

    Pagination<SellerDto> findSellerWithFilter(int pageIndex, int pageSize, String searchKey, UUID category);
}
