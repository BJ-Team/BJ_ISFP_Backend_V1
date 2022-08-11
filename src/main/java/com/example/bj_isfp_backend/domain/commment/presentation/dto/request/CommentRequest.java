package com.example.bj_isfp_backend.domain.commment.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CommentRequest {

    @Size(max = 50, message = "content는 50자 이내로 입력해주세요.")
    @NotBlank(message = "content는 필수 입력입니다.")
    private String content;
}
