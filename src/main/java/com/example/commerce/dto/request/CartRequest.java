package com.example.commerce.dto.request;

import com.example.commerce.domain.Cart;
import com.example.commerce.domain.Item;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private Long customerNo;
    private Long itemNo;
    private Long count;

    public Cart toEntity(Item item) {
        return Cart.builder()
                .customerNo(this.getCustomerNo())
                .item(item)
                .count(this.getCount())
                .registerDate(LocalDateTime.now())
                .build();
    }
}
