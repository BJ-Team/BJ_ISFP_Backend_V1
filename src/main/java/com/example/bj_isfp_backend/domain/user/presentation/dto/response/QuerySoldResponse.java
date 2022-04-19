package com.example.bj_isfp_backend.domain.user.presentation.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QuerySoldResponse {

    private final List<SoldResponse> soldResponseList;

    @Getter
    public static class SoldResponse {
        private final String title;
        private final String location;

        @QueryProjection
        public SoldResponse(String title, String location) {
            this.title = title;
            this.location = location;
        }
    }
}
