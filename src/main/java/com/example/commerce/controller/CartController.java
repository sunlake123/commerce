package com.example.commerce.controller;

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
    public ResponseEntity putItemToCart (@RequestBody CartRequest request) {
        cartService.addItem(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getItemsFromCart(@RequestParam Long customerNo) {
        List<CartDto> carts = cartService.getList(customerNo);
        return ResponseEntity.ok(carts);
    }

    @DeleteMapping("/delete-item")
    public ResponseEntity deleteItemFromCart(@RequestParam Long customerNo, @RequestParam Long itemNo) {
        cartService.deleteItem(customerNo, itemNo);
        return ResponseEntity.ok().build();
    }
}