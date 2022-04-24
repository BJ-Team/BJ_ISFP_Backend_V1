package com.example.bj_isfp_backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class QueryUserPostResponse {

    private final List<UserPost> userPostList;

    @Getter
    @Builder
    public static class UserPost {
        private final Long userId;
        private final Long postId;
        private final String title;
        private final String location;
        private final LocalDateTime createTime;
        private final Integer price;
        private final String postImage;
    }
}
