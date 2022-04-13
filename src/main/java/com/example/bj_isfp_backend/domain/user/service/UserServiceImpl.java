package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.auth.exception.PasswordNotCorrectException;
import com.example.bj_isfp_backend.domain.auth.presentation.dto.TokenResponse;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.domain.repository.UserRepository;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.LoginRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.SignUpRequest;
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
                        .user_id(signUpRequest.getUser_id())
                        .password(passwordEncoder.encode(signUpRequest.getPassword()))
                        .name(signUpRequest.getName())
                        .place(signUpRequest.getPlace())
                        .sex(signUpRequest.getSex())
                        .build());
    }

    @Override
    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {

        User user = userFacade.getByUser_id(loginRequest.getUser_id());

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
            throw PasswordNotCorrectException.EXCEPTION;

        user.setDeviceToken(loginRequest.getDeviceToken());

        String access = jwtTokenProvider.generateAccessToken(loginRequest.getUser_id());
        String refresh = jwtTokenProvider.generateRefreshToken(loginRequest.getUser_id());

        return TokenResponse.builder()
                .accessToken(access)
                .expired_at(jwtTokenProvider.getExpiredTime())
                .refreshToken(refresh)
                .build();
    }
}
