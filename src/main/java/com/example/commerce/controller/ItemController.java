package com.example.commerce.controller;

import com.example.commerce.dto.request.ItemRequest;
import com.example.commerce.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity addItem(@RequestBody ItemRequest request) {
        itemService.addItem(request);
        return ResponseEntity.ok().build();
    }
}
