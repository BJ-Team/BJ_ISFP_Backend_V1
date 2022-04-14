package com.example.bj_isfp_backend.domain.user.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "accountId는 필수 입력입니다.")
    private String accountId;

    @NotBlank(message = "password는 필수 입력입니다.")
    private String password;

    @NotBlank(message = "deviceToken은 필수 입력입니다.")
    private String deviceToken;
}
