package com.example.bj_isfp_backend.domain.commment.domain.repository;

import com.example.bj_isfp_backend.domain.commment.domain.repository.vo.CommentListVO.CommentVO;

import java.util.List;

public interface CommentRepositoryCustom {

    List<CommentVO> queryCommentList(Long lifeId);
}
