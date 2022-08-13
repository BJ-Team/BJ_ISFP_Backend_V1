package com.example.bj_isfp_backend.domain.post.domain.repository;


import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostDetailsVO.PostVO;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostListVO.PostResponse;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.QPostDetailsVO_PostVO;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.QPostDetailsVO_Writer;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.QPostListVO_PostResponse;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.bj_isfp_backend.domain.post.domain.QPost.post;
import static com.example.bj_isfp_backend.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final UserFacade userFacade;

    @Override
    public List<PostResponse> queryPostList() {
        User currentUser = userFacade.getCurrentUser();

        return jpaQueryFactory.select(
                        new QPostListVO_PostResponse(
                                post.title,
                                post.location,
                                post.isReported,
                                post.createTime,
                                post.price,
                                post.postImage,
                                post.id
                        ))
                .from(post)
                .where(
                        post.location.eq(currentUser.getLocation())
                )
                .orderBy(post.id.desc())
                .fetch();
    }

    @Override
    public PostVO queryPostDetails(Long postId) {
        return jpaQueryFactory
                .select(
                        new QPostDetailsVO_PostVO(
                                post.title,
                                post.content,
                                post.category,
                                post.location,
                                post.createTime,
                                post.isLiked,
                                post.price,
                                post.postImage,
                                new QPostDetailsVO_Writer(
                                        user.id,
                                        user.name,
                                        user.userProfile
                                ))
                )
                .from(post)
                .leftJoin(post.user, user)
                .where(
                        post.id.eq(postId)
                )
                .fetchOne();
    }
}
