package com.example.commerce.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity(name = "CART")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartNo;
    private Long customerNo;
    @ManyToOne
    @JoinColumn(name = "item_no")
    private Item item;
    private Long count;
    private LocalDateTime registerDate;

    public void addCount(long count) {
        this.count += count;
    }
}
