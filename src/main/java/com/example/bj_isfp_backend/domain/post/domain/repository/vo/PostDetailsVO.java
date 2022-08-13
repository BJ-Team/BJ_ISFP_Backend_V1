package com.example.bj_isfp_backend.domain.post.domain.repository.vo;

import com.example.bj_isfp_backend.domain.post.domain.type.PostCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostDetailsVO {

    @Getter
    @Builder
    public static class PostVO{
        private final String title;
        private final String content;
        private final PostCategory postCategory;
        private final String location;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private final LocalDateTime createTime;
        private final boolean isLiked;
        private final Integer price;
        private final String postImage;
        private final Writer writer;

        @QueryProjection
        public PostVO(String title, String content, PostCategory postCategory, String location, LocalDateTime createTime, boolean isLiked, Integer price, String postImage, Writer writer) {
            this.title = title;
            this.content = content;
            this.postCategory = postCategory;
            this.location = location;
            this.createTime = createTime;
            this.isLiked = isLiked;
            this.price = price;
            this.postImage = postImage;
            this.writer = writer;
        }
    }

    @Getter
    @Builder
    public static class Writer {
        private final Long userId;
        private final String username;
        private final String userProfile;

        @QueryProjection
        public Writer(Long userId, String username, String userProfile) {
            this.userId = userId;
            this.username = username;
            this.userProfile = userProfile;
        }
    }
}
