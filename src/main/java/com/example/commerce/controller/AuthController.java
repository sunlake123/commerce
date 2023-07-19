package com.example.commerce.controller;

import com.example.commerce.Auth.TokenProvider;
import com.example.commerce.domain.Customer;
import com.example.commerce.dto.Auth;
import com.example.commerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomerService customerService;

    @PostMapping("/signUp")
    public ResponseEntity<Customer> signUp(@RequestBody Auth.SignUp request) {
        Customer customer = customerService.register(request);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody Auth.SignIn request) {
        String token = customerService.authenticate(request);
        System.out.println("token = " + token);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/test")
    public Map userResponse() {
        Map<String, String> result = new HashMap<>();
        result.put("result", "user ok");
        return result;
    }
}
