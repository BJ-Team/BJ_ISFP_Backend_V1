package com.example.bj_isfp_backend.domain.commment.domain.repository.vo;

import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeDetailsVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class CommentListVO {

    private final List<CommentVO> commentList;

    @Getter
    @Builder
    public static class CommentVO {

        private final Long commentId;
        private final String content;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private final LocalDateTime createTime;
        private final Writer writer;

        @QueryProjection
        public CommentVO(Long commentId, String content, LocalDateTime createTime, Writer writer) {
            this.commentId = commentId;
            this.content = content;
            this.createTime = createTime;
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
