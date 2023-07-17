package com.example.commerce.controller;

import com.example.commerce.Auth.TokenProvider;
import com.example.commerce.domain.Customer;
import com.example.commerce.dto.Auth;
import com.example.commerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomerService customerService;
    private final TokenProvider tokenProvider;

    @PostMapping("/signUp")
    public ResponseEntity<Customer> signUp(@RequestBody Auth.SignUp request) {
        Customer customer = customerService.register(request);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody Auth.SignIn request) {
        Customer customer = customerService.authenticate(request);
        tokenProvider.generateToken(customer.getEmail(), customer.getRole());
        return ResponseEntity.ok(customer);
    }
}
