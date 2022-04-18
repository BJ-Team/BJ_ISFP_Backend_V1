package com.example.bj_isfp_backend.domain.user.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class UserVO {

    private final Long userId;
    private final String name;
    private final String nowMyLocation;
    private final String userProfile;

    @QueryProjection
    public UserVO(Long userId, String name, String nowMyLocation, String userProfile) {
        this.userId = userId;
        this.name = name;
        this.nowMyLocation = nowMyLocation;
        this.userProfile = userProfile;
    }
}
