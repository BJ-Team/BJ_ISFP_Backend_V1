package com.example.bj_isfp_backend.domain.user.presentation;

import com.example.bj_isfp_backend.domain.auth.presentation.dto.TokenResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.DuplicateNameCheckRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.LoginRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.SignUpRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.example.bj_isfp_backend.domain.user.presentation.dto.request.UpdatePlaceRequest;
import com.example.bj_isfp_backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public void register(@RequestBody @Valid SignUpRequest signUpRequest) {
        userService.signUp(signUpRequest);
    }

    @PostMapping("/token")
    public TokenResponse token(@RequestBody @Valid LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/password")
    public void password(@RequestBody @Valid UpdatePasswordRequest updatePasswordRequest) {
        userService.updatePassword(updatePasswordRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/place")
    public void place(@RequestBody @Valid UpdatePlaceRequest updatePlaceRequest) {
        userService.updatePlace(updatePlaceRequest);
    }

    @PostMapping("/name")
    public void name(@RequestBody @Valid DuplicateNameCheckRequest duplicateNameCheckRequest) {
        userService.duplicateNameCheck(duplicateNameCheckRequest);
    }
}
