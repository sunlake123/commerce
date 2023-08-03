package com.example.commerce.service;

import com.example.commerce.domain.Cart;
import com.example.commerce.domain.Item;
import com.example.commerce.dto.CartDto;
import com.example.commerce.dto.ItemDto;
import com.example.commerce.dto.request.CartRequest;
import com.example.commerce.dto.request.ItemRequest;
import com.example.commerce.repository.CartRepository;
import com.example.commerce.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public void addItem(ItemRequest request) {
        itemRepository.save(request.toEntity());
    }
}
