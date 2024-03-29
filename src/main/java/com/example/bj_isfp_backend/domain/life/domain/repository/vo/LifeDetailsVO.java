package com.example.bj_isfp_backend.domain.life.domain.repository.vo;

import com.example.bj_isfp_backend.domain.commment.domain.repository.vo.CommentListVO.CommentVO;
import com.example.bj_isfp_backend.domain.life.domain.type.LifeCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class LifeDetailsVO {

    @Getter
    @Builder
    public static class LifeVO {
        private final String content;
        private final LifeCategory category;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private final LocalDateTime createTime;
        private final String location;
        private final String lifeImage;
        private final Writer writer;

        private final List<CommentVO> comment = new ArrayList<>();

        @QueryProjection
        public LifeVO(String content, LifeCategory category, LocalDateTime createTime, String location, String lifeImage, Writer writer) {
            this.content = content;
            this.category = category;
            this.createTime = createTime;
            this.location = location;
            this.lifeImage = lifeImage;
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
