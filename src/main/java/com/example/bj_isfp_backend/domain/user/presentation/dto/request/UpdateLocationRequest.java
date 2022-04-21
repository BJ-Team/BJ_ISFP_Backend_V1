package com.example.bj_isfp_backend.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UpdateLocationRequest {

    @NotBlank(message = "location는 필수 입력입니다.")
    private String location;
}
