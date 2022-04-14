package com.example.bj_isfp_backend.domain.post.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    DIGITAL("디지털"),
    LIFE("생활"),
    CHILD("유아"),
    SPORTS("스포츠"),
    GIFT_CARD("기프티콘"),
    STUFF("잡화"),
    GAME("게임"),
    BOOK("도서"),
    PLANT("식물"),
    ETC("기타"),
    PURCHASE("구매");

    private final String name;
}
