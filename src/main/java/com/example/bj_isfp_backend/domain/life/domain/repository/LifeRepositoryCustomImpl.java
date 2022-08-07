package com.example.bj_isfp_backend.domain.life.domain.repository;

import com.example.bj_isfp_backend.domain.life.presentation.dto.response.QQueryLifeResponse_LifeResponse;
import com.example.bj_isfp_backend.domain.life.presentation.dto.response.QueryLifeResponse.LifeResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.bj_isfp_backend.domain.life.domain.QLife.life;
import static com.example.bj_isfp_backend.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class LifeRepositoryCustomImpl implements LifeRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<LifeResponse> queryLifeList() {
        return jpaQueryFactory
                .select(new QQueryLifeResponse_LifeResponse(
                        life.content,
                        life.category,
                        life.createTime,
                        life.lifeImage,
                        user.id
                ))
                .from(life)
                .leftJoin(life.user, user)
                .fetch();
    }
}
