package com.example.amazonsearchbe.controller;

import com.example.amazonsearchbe.dto.BrandDto;
import com.example.amazonsearchbe.dto.SuccessResponse;
import com.example.amazonsearchbe.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brands")
@CrossOrigin("*")
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/with-products")
    public SuccessResponse<List<BrandDto>> findBrandLinkWithProduct(
            @RequestParam(name = "searchKey", defaultValue = "")
            String searchKey,
            @RequestParam(name = "categories", defaultValue = "")
            List<UUID> categories
    ) {
        return new SuccessResponse<>(brandService.findBrandLinkWithProduct(searchKey,
                categories));
    }
}
