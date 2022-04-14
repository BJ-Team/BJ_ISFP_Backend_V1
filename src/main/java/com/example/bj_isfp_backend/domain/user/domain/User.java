package com.example.bj_isfp_backend.domain.user.domain;

import com.example.bj_isfp_backend.domain.user.domain.type.Sex;
import com.example.bj_isfp_backend.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String accountId;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private String place;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "device_token")
    private String deviceToken;

    @Builder
    public User(String accountId, String password, String name, String place, Sex sex) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.place = place;
        if (sex != null) this.sex = sex;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
