package com.example.bj_isfp_backend.domain.auth.presentation;

import com.example.bj_isfp_backend.domain.auth.presentation.dto.TokenResponse;
import com.example.bj_isfp_backend.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public TokenResponse reissue(@RequestHeader("Refresh-Token") String refreshToken) {
        return authService.reissue(refreshToken);
    }
}
