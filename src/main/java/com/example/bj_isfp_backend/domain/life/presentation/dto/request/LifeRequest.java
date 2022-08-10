package com.example.bj_isfp_backend.domain.life.presentation.dto.request;

import com.example.bj_isfp_backend.domain.life.domain.type.LifeCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class LifeRequest {

    @Size(max = 300, message = "content는 300자 이내로 입력해주세요.")
    @NotBlank(message = "content는 필수 입력입니다.")
    private String content;

    @NotNull(message = "category는 필수 입력입니다.")
    private LifeCategory category;

    private String lifeImage;
}
