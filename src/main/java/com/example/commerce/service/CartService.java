package com.example.commerce.service;

import com.example.commerce.Exception.ItemNotFoundException;
import com.example.commerce.domain.Cart;
import com.example.commerce.domain.Item;
import com.example.commerce.dto.CartDto;
import com.example.commerce.dto.request.CartRequest;
import com.example.commerce.repository.CartRepository;
import com.example.commerce.repository.CustomerRepository;
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
public class CartService {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public void addItem(String email, CartRequest request) {

        Item item = itemRepository.findById(request.getItemNo())
                .orElseThrow(() -> new ItemNotFoundException("해당하는 상품이 없습니다."));

        Optional<Cart> cart = cartRepository.findByEmailAndItem(email, item);

        if (cart.isEmpty()) {
            cartRepository.save(request.toEntity(email, item));
        } else {
            cart.get().addCount(request.getCount());
        }
    }

    public List<CartDto> getList(String email) {

        List<Cart> carts = cartRepository.findAllByEmailOrderByRegisterDateDesc(email).get();

        List<CartDto> cartDtos = new ArrayList<>();

        for (Cart cart : carts) {
            Item item = cart.getItem();
            cartDtos.add(CartDto.builder()
                    .itemNo(item.getItemNo())
                    .name(item.getName())
                    .image(item.getImage())
                    .price(item.getPrice())
                    .count(cart.getCount())
                    .build());
        }

        return cartDtos;
    }

    public void deleteItem(String email, Long itemNo) {
        Item item = itemRepository.findById(itemNo).orElseThrow(() ->
                new ItemNotFoundException("해당 상품이 존재하지 않습니다."));

        Cart cart = cartRepository.findByEmailAndItem(email, item).orElseThrow(() ->
                new ItemNotFoundException("장바구니에 해당 상품이 존재하지 않습니다."));

        cartRepository.delete(cart);
    }

    public void updateItem(String email, CartRequest request) {
        Item item = itemRepository.findById(request.getItemNo()).orElseThrow(() ->
                new ItemNotFoundException("해당 상품이 존재하지 않습니다."));

        Cart cart = cartRepository.findByEmailAndItem(email, item).orElseThrow(() ->
                new ItemNotFoundException("장바구니에 해당 상품이 존재하지 않습니다."));

        cart.setItemCount(request.getCount());
    }
}