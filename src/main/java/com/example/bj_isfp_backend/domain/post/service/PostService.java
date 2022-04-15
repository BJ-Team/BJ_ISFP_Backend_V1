package com.example.bj_isfp_backend.domain.post.service;

import com.example.bj_isfp_backend.domain.post.presentation.dto.CreatePostRequest;

public interface PostService {

    void createPost(CreatePostRequest createPostRequest);

    void deletePost(Long postId);
}
