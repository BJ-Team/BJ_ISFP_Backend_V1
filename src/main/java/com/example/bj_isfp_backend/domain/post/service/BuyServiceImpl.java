package com.example.bj_isfp_backend.domain.post.service;

import com.example.bj_isfp_backend.domain.post.domain.Buy;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.post.domain.repository.BuyRepository;
import com.example.bj_isfp_backend.domain.post.domain.repository.PostRepository;
import com.example.bj_isfp_backend.domain.post.exception.AlreadySoldException;
import com.example.bj_isfp_backend.domain.post.exception.PostNotFoundException;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BuyServiceImpl implements BuyService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;
    private final BuyRepository buyRepository;

    @Override
    @Transactional
    public void postBuy(Long postId) {

        User user = userFacade.getCurrentUser();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if (post.isSold())
            throw AlreadySoldException.EXCEPTION;

        post.sold();

        buyRepository.save(
                Buy.builder()
                        .user(user)
                        .post(post)
                        .build());
    }
}
