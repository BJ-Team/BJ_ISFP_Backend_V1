package com.example.bj_isfp_backend.domain.post.domain.repository.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostListVO {
    private final List<PostResponse> postList;

    @Getter
    public static class PostResponse {
        private final String title;
        private final String location;
        private final boolean isLiked;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private final LocalDateTime createTime;
        private final Integer price;
        private final String postImage;
        private final Long postId;

        @QueryProjection
        public PostResponse(String title, String location, boolean isLiked, LocalDateTime createTime, Integer price, String postImage, Long postId) {
            this.title = title;
            this.location = location;
            this.isLiked = isLiked;
            this.createTime = createTime;
            this.price = price;
            this.postImage = postImage;
            this.postId = postId;
        }
    }
}
