package com.example.bj_isfp_backend.domain.user.domain.repository;

import com.example.bj_isfp_backend.domain.user.domain.repository.vo.LikeVO;
import com.example.bj_isfp_backend.domain.user.domain.repository.vo.QLikeVO;
import com.example.bj_isfp_backend.domain.user.domain.repository.vo.QSoldVO;
import com.example.bj_isfp_backend.domain.user.domain.repository.vo.QUserVO;
import com.example.bj_isfp_backend.domain.user.domain.repository.vo.SoldVO;
import com.example.bj_isfp_backend.domain.user.domain.repository.vo.UserVO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.bj_isfp_backend.domain.post.domain.QPost.post;
import static com.example.bj_isfp_backend.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public UserVO queryUserInfo() {
        return jpaQueryFactory
                .select(new QUserVO(
                        user.id,
                        user.name,
                        user.userProfile,
                        user.nowMyLocation
                ))
                .from(user)
                .fetchOne();
    }

    @Override
    public List<SoldVO> queryMyPageSoldList() {
        return jpaQueryFactory
                .select(new QSoldVO(
                        post.title,
                        user.nowMyLocation
                ))
                .from(post)
                .join(post.user, user)
                .fetch();
    }

    @Override
    public List<LikeVO> queryMyPageLikeList() {
        return jpaQueryFactory
                .select(new QLikeVO(
                        post.title,
                        user.nowMyLocation,
                        post.price,
                        post.postImage
                ))
                .from(post)
                .join(post.user, user)
                .fetch();
    }
}
