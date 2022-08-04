package com.example.bj_isfp_backend.domain.post.presentation;

import com.example.bj_isfp_backend.domain.post.presentation.dto.request.PostRequest;
import com.example.bj_isfp_backend.domain.post.presentation.dto.response.QueryPostResponse;
import com.example.bj_isfp_backend.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/make")
    public void makePost(@RequestBody @Valid PostRequest postRequest) {
        postService.createPost(postRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{post-id}")
    public void deletePost(@PathVariable(name = "post-id") Long postId) {
        postService.deletePost(postId);
    }

    @GetMapping
    public QueryPostResponse queryPost() {
        return postService.queryPostList();
    }

    @PatchMapping("/{post-id}")
    public void updatePost(@PathVariable(name = "post-id") Long postId, PostRequest postRequest) {
        postService.updatePost(postId, postRequest);
    }
}
