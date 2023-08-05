package com.example.commerce.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
    private Long itemNo;    // ItemDetail로 넘어가기 위한 id
    private String name;
    private String image;
    private Long price;
    private Long count;
}
