package com.example.bj_isfp_backend.domain.user.domain.repository;

import com.example.bj_isfp_backend.domain.user.domain.repository.vo.QUserVO;
import com.example.bj_isfp_backend.domain.user.domain.repository.vo.UserVO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.bj_isfp_backend.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public UserVO queryMyPageInfo() {
        return jpaQueryFactory
                .select(new QUserVO(
                        user.id,
                        user.name,
                        user.userProfile,
                        user.location
                ))
                .from(user)
                .fetchOne();
    }
}
