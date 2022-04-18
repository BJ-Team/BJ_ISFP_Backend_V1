package com.example.bj_isfp_backend.domain.post.presentation;

import com.example.bj_isfp_backend.domain.post.presentation.dto.request.CreatePostRequest;
import com.example.bj_isfp_backend.domain.post.presentation.dto.response.QueryPostResponse;
import com.example.bj_isfp_backend.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/make")
    public void make(@RequestBody @Valid CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{post-id}")
    public void delete(@PathVariable(name = "post-id") Long postId) {
        postService.deletePost(postId);
    }

    @GetMapping
    public QueryPostResponse queryPost() {
        return postService.queryPostList();
    }
}
