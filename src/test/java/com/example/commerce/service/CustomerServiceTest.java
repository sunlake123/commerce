package com.example.commerce.service;

import com.example.commerce.Auth.TokenProvider;
import com.example.commerce.dto.request.AuthRequest;
import com.example.commerce.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.commerce.domain.Role.ROLE_CUSTOMER;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private TokenProvider tokenProvider;
    @InjectMocks
    private CustomerService customerService;

    @Test
    @DisplayName("회원가입 성공")
    void registerSuccess() {
        // given
        AuthRequest.SignUp customer1 = AuthRequest.SignUp.builder()
                .email("john123@naver.com")
                .password("4321")
                .username("아d아")
                .zipcode("01242")
                .address("가나다라다")
                .phone("010-4321-5678")
                .role(ROLE_CUSTOMER)
                .build();
        // when

        // then
    }

    @Test
    @DisplayName("회원가입 실패 - 중복된 이메일")
    void registerFailed_Duplicate() {
        // given
        AuthRequest.SignUp customer1 = AuthRequest.SignUp.builder()
                .email("john123@naver.com")
                .password("4321")
                .username("아d아")
                .zipcode("01242")
                .address("가나다라다")
                .phone("010-4321-5678")
                .role(ROLE_CUSTOMER)
                .build();
        AuthRequest.SignUp customer2 = AuthRequest.SignUp.builder()
                .email("john123@naver.com")
                .password("1234")
                .username("아아")
                .zipcode("01244")
                .address("서울특별시 용산구 동부이촌동 한가람아파트")
                .phone("010-1234-5678")
                .role(ROLE_CUSTOMER)
                .build();
        // when
        given(customerService.register(customer1));
        // then
        assertThrows(RuntimeException.class, () ->
                customerService.register(customer2));
    }
}