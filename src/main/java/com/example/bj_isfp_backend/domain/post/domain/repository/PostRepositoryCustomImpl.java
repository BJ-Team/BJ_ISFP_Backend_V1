package com.example.bj_isfp_backend.domain.post.domain.repository;


import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostDetailsVO;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostListVO.PostVO;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.QPostDetailsVO;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.QPostListVO_PostVO;
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
    public List<PostVO> queryPostList() {
        User currentUser = userFacade.getCurrentUser();

        return jpaQueryFactory.select(
                        new QPostListVO_PostVO(
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
                .fetch();
    }

    @Override
    public PostDetailsVO queryPostDetails(Long postId) {
        return jpaQueryFactory.select(
                        new QPostDetailsVO(
                                post.title,
                                post.content,
                                post.category,
                                post.location,
                                post.createTime,
                                post.isReported,
                                post.price,
                                post.postImage,
                                user.name,
                                user.userProfile,
                                user.id
                        ))
                .from(post)
                .leftJoin(post.user, user)
                .where(
                        post.id.eq(postId)
                )
                .fetchOne();
    }
}
