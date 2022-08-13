package com.example.bj_isfp_backend.domain.life.domain;

import com.example.bj_isfp_backend.domain.commment.domain.Comment;
import com.example.bj_isfp_backend.domain.life.domain.type.LifeCategory;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Life extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(max = 300)
    private String content;

    @Column(nullable = false)
    private LifeCategory category;

    private String location;
    private String lifeImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder
    public Life(String content, LifeCategory category, String location, String lifeImage, User user, Comment comment) {
        this.content = content;
        this.category = category;
        this.location = location;
        if (lifeImage != null) this.lifeImage = lifeImage;
        this.user = user;
        this.comment = comment;
    }

    public void updateLife(String content, LifeCategory category, String location, String lifeImage) {
        this.content = content;
        this.category = category;
        this.location = location;
        if (lifeImage != null) this.lifeImage = lifeImage;
    }
}
