package com.example.bj_isfp_backend.domain.post.presentation.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class QueryPostResponse {

    private final List<PostResponse> postResponse;

    @Getter
    public static class PostResponse {
        private final String title;
        private final String location;
        private final LocalDateTime createTime;
        private final Integer price;
        private final String postImage;
        private final Long postId;

        @QueryProjection
        public PostResponse(String title, String location, LocalDateTime createTime, Integer price, String postImage, Long postId) {
            this.title = title;
            this.location = location;
            this.createTime = createTime;
            this.price = price;
            this.postImage = postImage;
            this.postId = postId;
        }
    }
}