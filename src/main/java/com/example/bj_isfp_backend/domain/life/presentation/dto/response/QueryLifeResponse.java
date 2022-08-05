package com.example.bj_isfp_backend.domain.life.presentation.dto.response;

import com.example.bj_isfp_backend.domain.life.domain.type.LifeCategory;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class QueryLifeResponse {

    private final List<LifeResponse> lifeResponses;

    @Getter
    public static class LifeResponse {
        private final String content;

        private final LifeCategory category;
        private final LocalDateTime createTime;
        private final String lifeImage;
        private final Long lifeId;

        @QueryProjection
        public LifeResponse(String content, LifeCategory category, LocalDateTime createTime, String lifeImage, Long lifeId) {
            this.content = content;
            this.category = category;
            this.createTime = createTime;
            this.lifeImage = lifeImage;
            this.lifeId = lifeId;
        }
    }
}
