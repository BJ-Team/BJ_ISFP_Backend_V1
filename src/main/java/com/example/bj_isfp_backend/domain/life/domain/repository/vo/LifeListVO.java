package com.example.bj_isfp_backend.domain.life.domain.repository.vo;

import com.example.bj_isfp_backend.domain.life.domain.type.LifeCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class LifeListVO {
    private final List<LifeResponse> lifeResponses;

    @Getter
    public static class LifeResponse {
        private final String content;
        private final LifeCategory category;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private final LocalDateTime createTime;
        private final String location;
        private final String lifeImage;
        private final Long lifeId;

        @QueryProjection
        public LifeResponse(String content, LifeCategory category, LocalDateTime createTime, String location, String lifeImage, Long lifeId) {
            this.content = content;
            this.category = category;
            this.createTime = createTime;
            this.location = location;
            this.lifeImage = lifeImage;
            this.lifeId = lifeId;
        }
    }
}
