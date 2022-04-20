package com.example.bj_isfp_backend.domain.like.presentation;

import com.example.bj_isfp_backend.domain.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class LikeController {

    private final LikeService postLikeService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/wish/{post-id}")
    public void wishPost(@PathVariable(name = "post-id") Long postId) {
        postLikeService.postLike(postId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/wish/cancel/{post-id}")
    public void wishCancel(@PathVariable(name = "post-id") Long postId) {
        postLikeService.postLikeCancel(postId);
    }
}
