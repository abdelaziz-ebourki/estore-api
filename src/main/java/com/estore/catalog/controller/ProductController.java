package com.estore.catalog.controller;

import com.estore.catalog.dto.ProductDto;
import com.estore.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final CatalogService catalogService;

    @GetMapping
    public Page<ProductDto> getAllProducts(Pageable pageable) {
        return catalogService.getAllProducts(pageable);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return catalogService.getProductById(id);
    }

    @GetMapping("/category/{categoryId}")
    public Page<ProductDto> getProductsByCategory(@PathVariable Long categoryId, Pageable pageable) {
        return catalogService.getProductsByCategory(categoryId, pageable);
    }

    @GetMapping("/search")
    public Page<ProductDto> searchProducts(@RequestParam String keyword, Pageable pageable) {
        return catalogService.searchProducts(keyword, pageable);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(catalogService.createProduct(productDto));
    }
}
