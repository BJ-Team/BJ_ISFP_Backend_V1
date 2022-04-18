package com.example.bj_isfp_backend.domain.post.domain.repository;

import com.example.bj_isfp_backend.domain.post.presentation.dto.response.QueryPostResponse.PostResponse;

import java.util.List;

public interface PostRepositoryCustom {
    List<PostResponse> queryPostList();
}
