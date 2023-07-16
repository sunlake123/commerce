package com.example.commerce.controller;

import com.example.commerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomerService customerService;

//    @GetMapping("/login")
//    public String login() {
//        System.out.println("get 로그인");
//        return id;
//    }

//    @PostMapping("/signUp")
//    public String signUp() {
//        System.out.println("post 로그인");
//
//    }
}
