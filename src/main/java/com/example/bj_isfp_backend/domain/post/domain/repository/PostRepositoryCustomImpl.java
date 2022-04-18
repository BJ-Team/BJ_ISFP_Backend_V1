package com.example.bj_isfp_backend.domain.post.domain.repository;

import com.example.bj_isfp_backend.domain.post.presentation.dto.response.QQueryPostResponse_PostResponse;
import com.example.bj_isfp_backend.domain.post.presentation.dto.response.QueryPostResponse.PostResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.bj_isfp_backend.domain.post.domain.QPost.post;

@RequiredArgsConstructor
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PostResponse> queryPostList() {
        return jpaQueryFactory
                .select(new QQueryPostResponse_PostResponse(
                        post.title,
                        post.user.place,
                        post.createTime,
                        post.price,
                        post.postImage,
                        post.id
                ))
                .from(post)
                .fetch();
    }
}
