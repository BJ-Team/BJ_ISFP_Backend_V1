package com.example.bj_isfp_backend.domain.user.domain;

import com.example.bj_isfp_backend.domain.user.domain.type.Sex;
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
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String accountId;

    @NotNull
    @Length(max = 60)
    private String password;

    @NotNull
    @Length(max = 20)
    private String name;

    @NotNull
    private String location;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String userProfile;

    @Column(name = "device_token")
    private String deviceToken;

    @Builder
    public User(String accountId, String password, String name, String location, Sex sex) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.location = location;
        if (sex != null) this.sex = sex;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}
