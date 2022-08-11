package com.example.bj_isfp_backend.domain.commment.facade;

import com.example.bj_isfp_backend.domain.commment.domain.Comment;
import com.example.bj_isfp_backend.domain.commment.domain.repository.CommentRepository;
import com.example.bj_isfp_backend.domain.commment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }
}
