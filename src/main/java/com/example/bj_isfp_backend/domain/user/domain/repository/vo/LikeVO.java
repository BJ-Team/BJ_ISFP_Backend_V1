package com.example.bj_isfp_backend.domain.user.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class LikeVO {

    private final String title;
    private final String location;
    private final Integer price;
    private final String postImage;

    @QueryProjection
    public LikeVO(String title, String location, Integer price, String postImage) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.postImage = postImage;
    }
}
