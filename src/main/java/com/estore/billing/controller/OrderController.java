package com.estore.billing.controller;

import com.estore.billing.entity.Order;
import com.estore.billing.service.BillingService;
import com.estore.customer.entity.User;
import com.estore.customer.repository.UserRepository;
import com.estore.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final BillingService billingService;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Order> placeOrder(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return ResponseEntity.ok(billingService.placeOrder(user.getId()));
    }

    @GetMapping
    public List<Order> getMyOrders(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return billingService.getOrdersByUserId(user.getId());
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Order> getAllOrders() {
        return billingService.getAllOrders();
    }
}
