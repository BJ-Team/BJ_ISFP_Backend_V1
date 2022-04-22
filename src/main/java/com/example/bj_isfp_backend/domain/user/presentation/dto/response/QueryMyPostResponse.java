package com.example.bj_isfp_backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QueryMyPostResponse {

    private final List<MyPost> myPostList;

    @Getter
    @Builder
    public static class MyPost {
        private final String title;
        private final String location;
        private final Integer price;
        private final String postImage;
    }
}
