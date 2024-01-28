package com.example.amazonsearchbe.controller;

import com.example.amazonsearchbe.dto.CategoryDto;
import com.example.amazonsearchbe.dto.SuccessResponse;
import com.example.amazonsearchbe.service.CategoryService;
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
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/parent")
    public SuccessResponse<List<CategoryDto>> findAllParentCategories(
    ) {
        return new SuccessResponse<>(categoryService.findAllParentCategories());
    }

    @GetMapping("/child")
    public SuccessResponse<List<CategoryDto>> findAllChildCategoryOfParent(
            @RequestParam(name = "id", required = false) UUID parentId
    ) {
        return new SuccessResponse<>(categoryService.findAllChildCategoryOfParent(parentId));
    }
}
