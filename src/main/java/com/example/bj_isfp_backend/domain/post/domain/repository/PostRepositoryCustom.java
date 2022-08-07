package com.example.bj_isfp_backend.domain.post.domain.repository;

import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostDetailsVO;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostListVO.PostVO;

import java.util.List;

public interface PostRepositoryCustom {
    List<PostVO> queryPostList();

    PostDetailsVO queryPostDetails(Long postId);
}
