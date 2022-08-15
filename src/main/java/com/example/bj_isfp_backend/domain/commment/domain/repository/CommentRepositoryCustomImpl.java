package com.example.bj_isfp_backend.domain.commment.domain.repository;

import com.example.bj_isfp_backend.domain.commment.domain.repository.vo.CommentListVO;
import com.example.bj_isfp_backend.domain.commment.domain.repository.vo.QCommentListVO_CommentVO;
import com.example.bj_isfp_backend.domain.commment.domain.repository.vo.QCommentListVO_Writer;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.bj_isfp_backend.domain.commment.domain.QComment.comment;
import static com.example.bj_isfp_backend.domain.life.domain.QLife.life;
import static com.example.bj_isfp_backend.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class CommentRepositoryCustomImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CommentListVO.CommentVO> queryCommentList(Long lifeId) {
        return jpaQueryFactory
                .select(new QCommentListVO_CommentVO(
                        comment.id,
                        comment.content,
                        comment.createTime,
                        new QCommentListVO_Writer(
                                user.id,
                                user.name,
                                user.userProfile
                        ))
                )
                .from(comment)
                .join(comment.life, life)
                .join(comment.user, user)
                .on(life.id.eq(lifeId))
                .orderBy(comment.id.asc())
                .fetch();
    }
}
