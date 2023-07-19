package com.example.commerce.Auth;

import antlr.Token;
import com.example.commerce.Exception.InvalidHeaderException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private static final String TOKEN_PREFIX = "Bearer ";
    private final TokenProvider tokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthInterceptor.preHandle");
        String token = resolveTokenFromRequest(request);

        tokenProvider.validateToken(token);

        String email = tokenProvider.getEmail(token);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private String resolveTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (ObjectUtils.isEmpty(token)) {
            throw new InvalidHeaderException("헤더 정보가 존재하지 않습니다.");
        }

        if (token.startsWith(TOKEN_PREFIX)) {
            throw new InvalidHeaderException("헤더 타입이 올바르지 않습니다.");
        }

        return token.substring(TOKEN_PREFIX.length());
    }
}
