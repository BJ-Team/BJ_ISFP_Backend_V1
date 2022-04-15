package com.example.bj_isfp_backend.domain.post.presentation;

import com.example.bj_isfp_backend.domain.post.presentation.dto.CreatePostRequest;
import com.example.bj_isfp_backend.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/make")
    public void make(@RequestBody @Valid CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
    }
}
