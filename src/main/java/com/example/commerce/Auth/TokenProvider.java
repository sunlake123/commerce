package com.example.commerce.Auth;

import com.example.commerce.Exception.InvalidTokenException;
import com.example.commerce.domain.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private static final long TOKEN_EXPIRE_TIME = 1000 * 60 * 60;
    private static final String KEY_ROLES = "roles";

    @Value("{spring.jwt.secret}")   // Application.yml에 존재
    private String secretKey;

    public String generateToken(String email, Role role) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put(KEY_ROLES, role);

        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + TOKEN_EXPIRE_TIME);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(HS512, secretKey)
                .compact();
    }

    public String getEmail(String token) {
        return this.parseClaims(token).getSubject();
    }

    public void validateToken(String token) {
        if (!StringUtils.hasText(token)) {  // 비어있는 값인지 체크
            throw new InvalidTokenException("토큰이 비어있습니다.");
        }
        Claims claims = this.parseClaims(token);

        if (claims.getExpiration().before(new Date())) {    // 만료시간 체크
            throw new InvalidTokenException("토큰 만료 시간이 지났습니다.");
        }
    }

    private Claims parseClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
