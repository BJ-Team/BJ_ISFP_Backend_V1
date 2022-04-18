package com.example.bj_isfp_backend.domain.post.presentation.dto.request;

import com.example.bj_isfp_backend.domain.post.domain.type.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CreatePostRequest {

    @NotBlank(message = "title 필수 입력입니다.")
    private String title;

    @NotBlank(message = "content 필수 입력입니다.")
    private String content;

    @NotNull(message = "category는 필수 입력입니다.")
    private Category category;

    @NotBlank(message = "price 필수 입력입니다.")
    private Integer price;
}
