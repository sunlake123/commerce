package com.example.commerce.dto.request;

import com.example.commerce.domain.Item;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

    private Integer categoryNo;
    private String name;
    private String content;
    private String image;
    private Long price;
    private Long count;

    public Item toEntity() {
        return Item.builder()
                .categoryNo(this.categoryNo)
                .name(this.name)
                .content(this.content)
                .image(this.image)
                .price(this.price)
                .count(this.count)
                .build();
    }
}
