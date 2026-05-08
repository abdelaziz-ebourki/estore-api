package com.estore.catalog.controller;

import com.estore.catalog.dto.CategoryDto;
import com.estore.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CatalogService catalogService;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return catalogService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {
        return catalogService.getCategoryById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(catalogService.createCategory(categoryDto));
    }
}
