package com.example.bj_isfp_backend.domain.life.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LifeCategory {

    QUESTION("질문"),
    ACCIDENT("사건사고"),
    RESTAURANT("맛집"),
    NEWS("소식"),
    HOBBIES("취미생활"),
    LOST("분실"),
    PLEASE("해주세요"),
    DAILY("일상"),
    PHOTO("사진전");

    private final String name;
}
