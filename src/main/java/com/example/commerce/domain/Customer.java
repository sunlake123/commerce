package com.example.commerce.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

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
    private String email;
    private String password;
//    private String username;
//    private String zipcode;
//    private String address1;
//    private String address2;
//    private String address3;
//    private String phone;
//    private LocalDateTime createDate;

}
