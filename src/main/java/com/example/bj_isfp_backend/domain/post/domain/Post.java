package com.example.bj_isfp_backend.domain.post.domain;

import com.example.bj_isfp_backend.domain.post.domain.type.PostCategory;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 300, nullable = false)
    private String content;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PostCategory category;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String location;

    private String postImage;

    @ColumnDefault("false")
    private boolean isSold;

    @ColumnDefault("false")
    private boolean isReported;

    @ColumnDefault("false")
    private boolean isLiked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Post(String title, String content, PostCategory category, Integer price, String location, String postImage, User user) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.price = price;
        this.location = location;
        this.user = user;
        if (postImage != null) this.postImage = postImage;
    }

    public void sold() {
        this.isSold = true;
    }

    public void reported() {
        this.isReported = true;
    }

    public void liked() {
        this.isLiked = true;
    }

    public void updatePost(String title, String content, PostCategory category, Integer price, String location, String postImage) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.price = price;
        this.location = location;
        if (postImage != null) this.postImage = postImage;
    }
}
