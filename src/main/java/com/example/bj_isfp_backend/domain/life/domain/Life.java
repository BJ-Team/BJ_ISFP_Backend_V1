package com.example.bj_isfp_backend.domain.life.domain;

import com.example.bj_isfp_backend.domain.life.domain.type.LifeCategory;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Life extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300, nullable = false)
    private String content;

    @Column(nullable = false)
    private LifeCategory category;
    private String lifeImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Life(String content, LifeCategory category, String lifeImage, User user) {
        this.content = content;
        this.category = category;
        this.user = user;
        if (lifeImage != null) this.lifeImage = lifeImage;
    }

    public void updateLife(String content, LifeCategory category, String lifeImage) {
        this.content = content;
        this.category = category;
        if (lifeImage != null) this.lifeImage = lifeImage;
    }
}
