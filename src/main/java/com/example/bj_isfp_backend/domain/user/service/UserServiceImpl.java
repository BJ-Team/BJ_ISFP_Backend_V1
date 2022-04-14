package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.auth.exception.PasswordNotCorrectException;
import com.example.bj_isfp_backend.domain.auth.presentation.dto.TokenResponse;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.domain.repository.UserRepository;
import com.example.bj_isfp_backend.domain.user.exception.InvalidUserException;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.LoginRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.SignUpRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.UpdatePasswordRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.UpdatePlaceRequest;
import com.example.bj_isfp_backend.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public void signUp(SignUpRequest signUpRequest) {

        userFacade.nameAlreadyExists(signUpRequest.getName());

        userRepository.save(
                User.builder()
                        .accountId(signUpRequest.getAccountId())
                        .password(passwordEncoder.encode(signUpRequest.getPassword()))
                        .name(signUpRequest.getName())
                        .place(signUpRequest.getPlace())
                        .sex(signUpRequest.getSex())
                        .build());
    }

    @Override
    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {

        User user = userFacade.getByAccountId(loginRequest.getAccountId());

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
            throw PasswordNotCorrectException.EXCEPTION;

        user.setDeviceToken(loginRequest.getDeviceToken());

        String access = jwtTokenProvider.generateAccessToken(loginRequest.getAccountId());
        String refresh = jwtTokenProvider.generateRefreshToken(loginRequest.getAccountId());

        return TokenResponse.builder()
                .accessToken(access)
                .expired_at(jwtTokenProvider.getExpiredTime())
                .refreshToken(refresh)
                .build();
    }

    @Override
    @Transactional
    public void updatePassword(UpdatePasswordRequest changePasswordRequest) {

        User user = userFacade.getCurrentUser();

        if (!user.getAccountId().equals(changePasswordRequest.getAccountId()))
            throw InvalidUserException.EXCEPTION;

        user.updatePassword(changePasswordRequest.getNewPassword());
    }

    @Override
    @Transactional
    public void updatePlace(UpdatePlaceRequest updatePlaceRequest) {

        User user = userFacade.getCurrentUser();

        user.updatePlace(updatePlaceRequest.getPlace());
    }
}
