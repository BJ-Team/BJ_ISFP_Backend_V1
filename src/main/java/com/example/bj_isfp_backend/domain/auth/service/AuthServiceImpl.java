package com.example.bj_isfp_backend.domain.auth.service;

import com.example.bj_isfp_backend.domain.auth.domain.RefreshToken;
import com.example.bj_isfp_backend.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.bj_isfp_backend.domain.auth.presentation.dto.TokenResponse;
import com.example.bj_isfp_backend.global.exception.InvalidJwtException;
import com.example.bj_isfp_backend.global.exception.RefreshTokenNotFoundException;
import com.example.bj_isfp_backend.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    @Transactional
    public TokenResponse reissue(String refreshToken) {

        if (!jwtTokenProvider.getBody(refreshToken).get("typ").equals("refresh"))
            throw InvalidJwtException.EXCEPTION;

        RefreshToken updateRefreshToken = refreshTokenRepository.findRefreshToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(updateRefreshToken.getAccountId());
        updateRefreshToken.updateToken(newRefreshToken);

        String newAccessToken = jwtTokenProvider.generateAccessToken(updateRefreshToken.getAccountId());

        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .expired_at(jwtTokenProvider.getExpiredTime())
                .refreshToken(refreshToken)
                .build();
    }
}
