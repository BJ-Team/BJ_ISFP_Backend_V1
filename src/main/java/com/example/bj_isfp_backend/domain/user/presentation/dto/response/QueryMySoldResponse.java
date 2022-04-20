package com.example.bj_isfp_backend.domain.user.presentation.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryMySoldResponse {

    private final List<MySold> mySoldList;

    @Getter
    @Builder
    public static class MySold {
        private final String title;
        private final String location;
    }
}
