package com.example.commerce.dto.request;

import com.example.commerce.domain.Customer;
import com.example.commerce.domain.Role;
import lombok.*;

import java.time.LocalDateTime;

public class AuthRequest {

    @Data
    public static class SignIn {
        private String email;
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SignUp {
        private String email;
        private String password;
        private String username;
        private String zipcode;
        private String address;
        private String phone;
        private Role role;

        public Customer toEntity() {
            return Customer.builder()
                    .email(this.email)
                    .password(this.password)
                    .username(this.username)
                    .zipcode(this.zipcode)
                    .address(this.address)
                    .phone(this.phone)
                    .role(this.role)
                    .createDate(LocalDateTime.now())
                    .build();
        }
    }
}
