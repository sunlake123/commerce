package com.example.commerce.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {

    private String name;
    private String content;
    private String image;
    private Long price;
    private Long count;

}
