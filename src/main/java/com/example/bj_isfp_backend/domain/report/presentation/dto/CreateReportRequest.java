package com.example.bj_isfp_backend.domain.report.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateReportRequest {

    @Size(max = 50, message = "title은 30자리 이내로 입력해주세요.")
    private String title;

    @Size(max = 300, message = "content은 300자리 이내로 입력해주세요.")
    private String content;

    @NotNull(message = "postId는 필수 입력입니다.")
    private Long postId;
}
