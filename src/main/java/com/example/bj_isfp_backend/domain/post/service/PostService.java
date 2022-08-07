package com.example.bj_isfp_backend.domain.post.service;

import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostListVO;
import com.example.bj_isfp_backend.domain.post.presentation.dto.request.PostRequest;

public interface PostService {

    void createPost(PostRequest postRequest);

    void deletePost(Long postId);

    PostListVO queryPostList();


    void updatePost(Long postId, PostRequest postRequest);
}
