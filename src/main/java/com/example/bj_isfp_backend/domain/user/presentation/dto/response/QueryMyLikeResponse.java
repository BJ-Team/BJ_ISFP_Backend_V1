package com.example.bj_isfp_backend.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryMyLikeResponse {

    private final List<MyLike> myLikeList;

    @Getter
    @Builder
    public static class MyLike {
        private final String title;
        private final String location;
        private final Integer price;
        private final String postImage;
    }
}
