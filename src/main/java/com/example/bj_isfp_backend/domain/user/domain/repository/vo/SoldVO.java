package com.example.bj_isfp_backend.domain.user.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class SoldVO {

    private final String title;
    private final String location;

    @QueryProjection
    public SoldVO(String title, String location) {
        this.title = title;
        this.location = location;
    }
}
