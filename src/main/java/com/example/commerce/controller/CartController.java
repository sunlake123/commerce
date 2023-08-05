package com.example.commerce.controller;

import com.example.commerce.Auth.CustomerEmail;
import com.example.commerce.dto.CartDto;
import com.example.commerce.dto.request.CartRequest;
import com.example.commerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/put-item")
    public ResponseEntity putItemToCart(@CustomerEmail String email, @RequestBody CartRequest request) {
        cartService.addItem(email, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getItemsFromCart(@RequestParam @CustomerEmail String email) {
        List<CartDto> carts = cartService.getList(email);
        return ResponseEntity.ok(carts);
    }

    @DeleteMapping("/delete-item")
    public ResponseEntity deleteItemFromCart(@CustomerEmail String email, @RequestParam Long itemNo) {
        cartService.deleteItem(email, itemNo);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update-item")
    public ResponseEntity updateItemFromCart(@CustomerEmail String email, @RequestBody CartRequest request) {
        cartService.updateItem(email, request);
        return ResponseEntity.ok().build();
    }
}