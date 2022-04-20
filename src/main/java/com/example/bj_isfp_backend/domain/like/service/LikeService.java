package com.example.bj_isfp_backend.domain.like.service;

public interface LikeService {

    void postLike(Long postId);

    void postLikeCancel(Long postId);
}
