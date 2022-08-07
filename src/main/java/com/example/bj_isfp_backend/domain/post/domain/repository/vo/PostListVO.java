package com.example.bj_isfp_backend.domain.post.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostListVO {
    private final List<PostVO> postVO;

    @Getter
    public static class PostVO {
        private final String title;
        private final String location;
        private final boolean isLiked;
        private final LocalDateTime createTime;
        private final Integer price;
        private final String postImage;
        private final Long postId;

        @QueryProjection
        public PostVO(String title, String location, boolean isLiked, LocalDateTime createTime, Integer price, String postImage, Long postId) {
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
