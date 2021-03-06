package com.example.bj_isfp_backend.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotBlank(message = "accountId는 필수 입력입니다.")
    private String accountId;

    @NotBlank(message = "password는 필수 입력입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}$",
            message = "비밀번호는 영문자와 숫자, 특수문자를 모두 포함해서 8~16자리 이내로 입력해주세요.")
    private String newPassword;
}
