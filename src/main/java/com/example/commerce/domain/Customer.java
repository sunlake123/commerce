package com.example.commerce.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "CUSTOMER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNo;
    @Email
    @NotNull
    @Column(unique = true)
    private String email;
    private String password;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    private String zipcode;
    @NotNull
    private String address;
    @NotNull
    @Column(unique = true)
    private String phone;
    private LocalDateTime createDate;
    private Role role;
}
