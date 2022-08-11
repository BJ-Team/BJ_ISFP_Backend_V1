package com.example.bj_isfp_backend.domain.commment.presentation;

import com.example.bj_isfp_backend.domain.commment.presentation.dto.request.CommentRequest;
import com.example.bj_isfp_backend.domain.commment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{life-id}")
    public void createComment(@PathVariable(name = "life-id") Long lifeId, @RequestBody @Valid CommentRequest commentRequest) {
        commentService.createComment(lifeId, commentRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{comment-id}")
    public void deleteComment(@PathVariable(name = "comment-id") Long commentId) {
        commentService.deleteComment(commentId);
    }
}
