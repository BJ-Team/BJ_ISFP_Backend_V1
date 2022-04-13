package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.presentation.dto.SignUpRequest;

public interface UserService {
    void signUp(SignUpRequest signUpRequest);
}
