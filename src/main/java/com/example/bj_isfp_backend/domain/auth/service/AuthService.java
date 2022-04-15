package com.example.bj_isfp_backend.domain.auth.service;

import com.example.bj_isfp_backend.domain.auth.presentation.dto.TokenResponse;

public interface AuthService {
    TokenResponse reissue(String refreshToken);
}
