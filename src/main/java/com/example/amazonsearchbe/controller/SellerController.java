package com.example.amazonsearchbe.controller;

import com.example.amazonsearchbe.dto.Pagination;
import com.example.amazonsearchbe.dto.SellerDto;
import com.example.amazonsearchbe.dto.SuccessResponse;
import com.example.amazonsearchbe.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers")
@CrossOrigin("*")
public class SellerController {

    private final SellerService sellerService;

    @GetMapping()
    public SuccessResponse<Pagination<SellerDto>> findSellerWithFilter(
            @RequestParam(name = "pageIndex", defaultValue = "0")
            @Min(value = 0)
            int pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "10")
            @Min(value = 1)
            int pageSize,
            @RequestParam(name = "searchKey", defaultValue = "")
            String searchKey,
            @RequestParam(name = "category", defaultValue = "")
            UUID category
    ) {
        return new SuccessResponse<>(sellerService.findSellerWithFilter(pageIndex, pageSize, searchKey, category));
    }
}
