package com.example.bj_isfp_backend.domain.post.domain;

import com.example.bj_isfp_backend.domain.post.domain.type.Category;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Category category;

    @Column(nullable = false)
    private Integer price;

    private String postImage;

    @ColumnDefault("false")
    private boolean isSold;

    @ColumnDefault("false")
    private boolean isReported;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Post(String title, String content, Category category, Integer price, String postImage, User user) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.price = price;
        this.user = user;
        if (postImage != null) this.postImage = postImage;
    }

    public void sold() {
        this.isSold = true;
    }

    public void reported() {
        this.isReported = true;
    }
}
