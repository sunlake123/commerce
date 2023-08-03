package com.example.commerce.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Entity(name = "CUSTOMER")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNo;
    @Email
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String username;
    private String zipcode;
    private String address;
    @Column(unique = true)
    private String phone;
    private LocalDateTime createDate;
    @Enumerated(EnumType.STRING)
    private Role role;
}
