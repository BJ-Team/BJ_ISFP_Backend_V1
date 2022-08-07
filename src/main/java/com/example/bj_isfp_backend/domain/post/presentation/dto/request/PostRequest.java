package com.example.bj_isfp_backend.domain.post.presentation.dto.request;

import com.example.bj_isfp_backend.domain.post.domain.type.PostCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class PostRequest {

    @Size(max = 50, message = "title은 50자 이내로 입력해주세요.")
    @NotBlank(message = "title 필수 입력입니다.")
    private String title;

    @Size(max = 300, message = "title은 300자 이내로 입력해주세요.")
    @NotBlank(message = "content 필수 입력입니다.")
    private String content;

    @NotNull(message = "category는 필수 입력입니다.")
    private PostCategory category;

    @NotBlank(message = "price 필수 입력입니다.")
    private Integer price;

    private String location;

    private String postImage;
}
