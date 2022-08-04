package com.example.bj_isfp_backend.domain.post.service;

import com.example.bj_isfp_backend.domain.post.presentation.dto.request.PostRequest;
import com.example.bj_isfp_backend.domain.post.presentation.dto.response.QueryPostResponse;

public interface PostService {

    void createPost(PostRequest postRequest);

    void deletePost(Long postId);

    QueryPostResponse queryPostList();

    void updatePost(Long postId, PostRequest postRequest);
}
