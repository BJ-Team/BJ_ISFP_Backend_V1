package com.example.bj_isfp_backend.domain.commment.service;

import com.example.bj_isfp_backend.domain.commment.presentation.dto.request.CommentRequest;

public interface CommentService {

    void createComment(Long lifeId, CommentRequest commentRequest);

    void deleteComment(Long commentId);
}
