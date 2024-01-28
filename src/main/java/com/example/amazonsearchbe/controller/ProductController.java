package com.example.amazonsearchbe.controller;

import com.example.amazonsearchbe.annotation.EnumValidate;
import com.example.amazonsearchbe.dto.Pagination;
import com.example.amazonsearchbe.dto.ProductDto;
import com.example.amazonsearchbe.dto.SuccessResponse;
import com.example.amazonsearchbe.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public SuccessResponse<Pagination<ProductDto>> findProductWithFilter(
            @RequestParam(name = "pageIndex", defaultValue = "0")
            @Min(value = 0)
            int pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "10")
            @Min(value = 1)
            int pageSize,
            @RequestParam(name = "searchKey", defaultValue = "")
            String searchKey,
            @RequestParam(name = "categories", defaultValue = "")
            List<UUID> categories,
            @RequestParam(name = "brands", defaultValue = "")
            List<UUID> brands,
            @RequestParam(name = "rating", required = false)
            Integer rating,
            @RequestParam(name = "min", required = false)
            Integer min,
            @RequestParam(name = "max", required = false)
            Integer max,
            @RequestParam(name = "isEs", defaultValue = "false")
            Boolean isEs,
            @RequestParam(name = "orderBy", defaultValue = "rating")
            String orderBy,
            @RequestParam(name = "orderDirection", defaultValue = "DESC")
            @EnumValidate(enumClass = Sort.Direction.class)
            Sort.Direction orderDirection
    ) {
        if (Boolean.FALSE.equals(isEs)) {
            return new SuccessResponse<>(
                    productService.findProductWithFilter(pageIndex, pageSize, searchKey,
                            categories, brands, rating, min, max, orderBy, orderDirection));
        } else {
            return new SuccessResponse<>(
                    productService.findProductWithFilterEs(pageIndex, pageSize, searchKey,
                            categories, brands, rating, min, max, orderBy, orderDirection));
        }
    }
}
