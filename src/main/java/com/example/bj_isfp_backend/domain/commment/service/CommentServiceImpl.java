package com.example.bj_isfp_backend.domain.commment.service;

import com.example.bj_isfp_backend.domain.commment.domain.Comment;
import com.example.bj_isfp_backend.domain.commment.domain.repository.CommentRepository;
import com.example.bj_isfp_backend.domain.commment.facade.CommentFacade;
import com.example.bj_isfp_backend.domain.commment.presentation.dto.request.CommentRequest;
import com.example.bj_isfp_backend.domain.life.domain.Life;
import com.example.bj_isfp_backend.domain.life.facade.LifeFacade;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.exception.InvalidUserException;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final LifeFacade lifeFacade;
    private final CommentFacade commentFacade;


    @Override
    @Transactional
    public void createComment(Long lifeId, CommentRequest commentRequest) {

        User user = userFacade.getCurrentUser();
        Life life = lifeFacade.getLifeById(lifeId);

        commentRepository.save(
                Comment.builder()
                        .content(commentRequest.getContent())
                        .user(user)
                        .life(life)
                        .build()
        );
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {

        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getCommentById(commentId);

        if (!comment.getUser().equals(user))
            throw InvalidUserException.EXCEPTION;

        commentRepository.delete(comment);
    }
}
