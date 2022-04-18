package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.auth.presentation.dto.TokenResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.DuplicateNameCheckRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.LoginRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.SignUpRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.UpdatePlaceRequest;

public interface UserService {

    void signUp(SignUpRequest signUpRequest);

    TokenResponse login(LoginRequest loginRequest);

    void updatePassword(UpdatePasswordRequest changePasswordRequest);

    void updatePlace(UpdatePlaceRequest updatePlaceRequest);

    void duplicateNameCheck(DuplicateNameCheckRequest duplicateNameCheckRequest);
}
