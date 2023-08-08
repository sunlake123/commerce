package com.example.commerce.dto.request;

import com.example.commerce.domain.Cart;
import com.example.commerce.domain.Item;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private Long itemNo;
    private Long count;

    public Cart toEntity(String email, Item item) {
        return Cart.builder()
                .email(email)
                .item(item)
                .count(this.getCount())
                .registerDate(LocalDateTime.now())
                .build();
    }
}
