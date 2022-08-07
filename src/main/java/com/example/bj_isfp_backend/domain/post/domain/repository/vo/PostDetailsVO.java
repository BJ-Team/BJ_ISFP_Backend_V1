package com.example.bj_isfp_backend.domain.post.domain.repository.vo;

import com.example.bj_isfp_backend.domain.post.domain.type.PostCategory;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDetailsVO {

    private final String title;
    private final String content;
    private final PostCategory postCategory;
    private final String location;
    private final LocalDateTime createTime;
    private final boolean isLiked;
    private final Integer price;
    private final String postImage;
    private final String userName;
    private final String userProfile;
    private final Long userId;

    @QueryProjection
    public PostDetailsVO(String title, String content, PostCategory postCategory, String location, LocalDateTime createTime, boolean isLiked, Integer price, String postImage, String userName, String userProfile, Long userId) {
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.location = location;
        this.createTime = createTime;
        this.isLiked = isLiked;
        this.price = price;
        this.postImage = postImage;
        this.userName = userName;
        this.userProfile = userProfile;
        this.userId = userId;
    }
}
