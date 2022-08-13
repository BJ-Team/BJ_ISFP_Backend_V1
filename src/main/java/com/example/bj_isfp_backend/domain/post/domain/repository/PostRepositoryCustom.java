package com.example.bj_isfp_backend.domain.post.domain.repository;

import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostDetailsVO.PostVO;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostListVO;

import java.util.List;

public interface PostRepositoryCustom {
    List<PostListVO.PostResponse> queryPostList();

    PostVO queryPostDetails(Long postId);
}
