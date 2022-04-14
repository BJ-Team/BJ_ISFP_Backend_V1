package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.auth.presentation.dto.TokenResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.DuplicateNameCheckRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.LoginRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.SignUpRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.UpdatePasswordRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.UpdatePlaceRequest;

public interface UserService {

    void signUp(SignUpRequest signUpRequest);

    TokenResponse login(LoginRequest loginRequest);

    void updatePassword(UpdatePasswordRequest changePasswordRequest);

    void updatePlace(UpdatePlaceRequest updatePlaceRequest);

    void duplicateNameCheck(DuplicateNameCheckRequest duplicateNameCheckRequest);
}
