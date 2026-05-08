package com.estore.inventory.controller;

import com.estore.inventory.entity.Inventory;
import com.estore.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/{productId}")
    public Inventory getInventory(@PathVariable Long productId) {
        return inventoryService.getInventoryByProductId(productId);
    }

    @PutMapping("/{productId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Inventory updateStock(@PathVariable Long productId, @RequestParam Integer quantity) {
        return inventoryService.updateStock(productId, quantity);
    }
}
