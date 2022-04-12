package com.example.bj_isfp_backend.global.security.jwt;

import com.example.bj_isfp_backend.domain.auth.domain.RefreshToken;
import com.example.bj_isfp_backend.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.bj_isfp_backend.global.exception.ExpiredJwtException;
import com.example.bj_isfp_backend.global.exception.InvalidJwtException;
import com.example.bj_isfp_backend.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    private String generateToken(String user_id, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(user_id)
                .claim("typ", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public String generateAccessToken(String user_id) {
        return generateToken(user_id, "access", jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String user_id) {

        String refresh = generateToken(user_id, "refresh", jwtProperties.getRefreshExp());

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .user_id(user_id)
                        .token(refresh)
                        .ttl(jwtProperties.getRefreshExp())
                        .build());
        return refresh;
    }

    public String resolveToken(HttpServletRequest request) {

        String bearer = request.getHeader(jwtProperties.getHeader());

        if (bearer != null && bearer.startsWith(jwtProperties.getPrefix()))
            return bearer.replace(jwtProperties.getPrefix(), "");
        return null;
    }

    public boolean validateToken(String token) {
        return getBody(token).getExpiration().after(new Date());
    }

    public Authentication getAuthentication(String token) {
        Claims body = getBody(token);

        if (body.getExpiration().before(new Date()))
            throw ExpiredJwtException.EXCEPTION;

        UserDetails userDetails = getUserDetails(body);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getBody(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }

    private UserDetails getUserDetails(Claims body) {
        return authDetailsService.loadUserByUsername(body.getSubject());
    }
}
