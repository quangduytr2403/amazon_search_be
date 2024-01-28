package com.example.amazonsearchbe.service.impl;

import com.example.amazonsearchbe.dto.Pagination;
import com.example.amazonsearchbe.dto.SellerDto;
import com.example.amazonsearchbe.entity.Seller;
import com.example.amazonsearchbe.repository.SellerRepository;
import com.example.amazonsearchbe.service.SellerService;
import com.example.amazonsearchbe.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Override
    public SellerDto findSellerById(UUID id) {
        return sellerRepository.findById(id).map(seller ->
                        SellerDto.builder()
                                .id(seller.getId())
                                .name(seller.getName())
                                .description(seller.getDescription())
                                .logo(seller.getLogo())
                                .createdAt(TimeUtils.convertLocalDateTimeToEpochMilli(seller.getCreatedAt()))
                                .updatedAt(TimeUtils.convertLocalDateTimeToEpochMilli(seller.getUpdatedAt()))
                                .deleted(seller.isDeleted())
                                .build())
                .orElse(null);
    }

    @Override
    public Pagination<SellerDto> findSellerWithFilter(int pageIndex, int pageSize, String searchKey, UUID category) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<Seller> sellerPage = sellerRepository.findSellerWithFilter(searchKey, category, pageable);
        List<Seller> sellers = sellerPage.getContent();

        List<SellerDto> sellerDtos = sellers.stream().map(seller ->
                        SellerDto.builder()
                                .id(seller.getId())
                                .name(seller.getName())
                                .description(seller.getDescription())
                                .logo(seller.getLogo())
                                .createdAt(TimeUtils.convertLocalDateTimeToEpochMilli(seller.getCreatedAt()))
                                .updatedAt(TimeUtils.convertLocalDateTimeToEpochMilli(seller.getUpdatedAt()))
                                .deleted(seller.isDeleted())
                                .build())
                .toList();

        return Pagination.create(sellerDtos, pageIndex, pageSize, sellerPage.getTotalElements());
    }
}
