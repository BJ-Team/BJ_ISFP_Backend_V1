package com.example.bj_isfp_backend.domain.auth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
@Builder
public class RefreshToken {

    @Id
    private String user_id;

    @Indexed
    private String token;

    @TimeToLive
    private Long ttl;

    public void updateToken(String token) {
        this.token = token;
    }
}
