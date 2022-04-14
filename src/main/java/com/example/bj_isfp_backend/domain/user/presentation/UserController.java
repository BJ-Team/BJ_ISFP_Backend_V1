package com.example.bj_isfp_backend.domain.user.presentation;

import com.example.bj_isfp_backend.domain.auth.presentation.dto.TokenResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.LoginRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.SignUpRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.UpdatePasswordRequest;
import com.example.bj_isfp_backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid SignUpRequest signUpRequest) {
        userService.signUp(signUpRequest);
    }

    @PostMapping("/token")
    public TokenResponse token(@RequestBody @Valid LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/password")
    public void password(@RequestBody @Valid UpdatePasswordRequest updatePasswordRequest) {
        userService.updatePassword(updatePasswordRequest);
    }
}
