package com.example.bj_isfp_backend.domain.buy.service;

import com.example.bj_isfp_backend.domain.buy.domain.Buy;
import com.example.bj_isfp_backend.domain.buy.domain.repository.BuyRepository;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.post.exception.AlreadySoldException;
import com.example.bj_isfp_backend.domain.post.facade.PostFacade;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BuyServiceImpl implements BuyService {

    private final UserFacade userFacade;
    private final PostFacade postFacade;
    private final BuyRepository buyRepository;

    @Override
    @Transactional
    public void postBuy(Long postId) {

        User user = userFacade.getCurrentUser();

        Post post = postFacade.getPostById(postId);

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
