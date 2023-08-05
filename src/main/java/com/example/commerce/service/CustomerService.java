package com.example.commerce.service;

import com.example.commerce.Auth.TokenProvider;
import com.example.commerce.domain.Customer;
import com.example.commerce.dto.request.AuthRequest;
import com.example.commerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public Customer register(AuthRequest.SignUp customer) {
        boolean exists = customerRepository.existsByEmail(customer.getEmail());
        if (exists) {
            throw new RuntimeException("이미 사용 중인 이메일입니다.");
        }

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        return customerRepository.save(customer.toEntity());
    }

    public String authenticate(AuthRequest.SignIn request) {
        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 이메일입니다."));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        String token = tokenProvider.generateToken(customer.getEmail(), customer.getRole());

        return token;
    }


}
