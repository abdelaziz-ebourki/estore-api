package com.estore.shopping.controller;

import com.estore.customer.entity.User;
import com.estore.customer.repository.UserRepository;
import com.estore.exception.ResourceNotFoundException;
import com.estore.shopping.entity.Cart;
import com.estore.shopping.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final ShoppingService shoppingService;
    private final UserRepository userRepository;

    @GetMapping
    public Cart getCart(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return shoppingService.getCartByUserId(user.getId());
    }

    @PostMapping("/add/{productId}")
    public Cart addItemToCart(@PathVariable Long productId, @RequestParam Integer quantity, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return shoppingService.addItemToCart(user.getId(), productId, quantity);
    }

    @PutMapping("/update/{productId}")
    public Cart updateItemQuantity(@PathVariable Long productId, @RequestParam Integer quantity, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return shoppingService.updateItemQuantity(user.getId(), productId, quantity);
    }

    @DeleteMapping("/remove/{productId}")
    public Cart removeItemFromCart(@PathVariable Long productId, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return shoppingService.removeItemFromCart(user.getId(), productId);
    }

    @DeleteMapping("/clear")
    public void clearCart(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        shoppingService.clearCart(user.getId());
    }
}
