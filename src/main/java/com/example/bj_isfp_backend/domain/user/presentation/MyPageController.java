package com.example.bj_isfp_backend.domain.user.presentation;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryUserPostResponse;
import com.example.bj_isfp_backend.domain.user.service.BoughtService;
import com.example.bj_isfp_backend.domain.user.service.LikedService;
import com.example.bj_isfp_backend.domain.user.service.MyPageService;
import com.example.bj_isfp_backend.domain.user.service.SoldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPageService myPageService;
    private final SoldService soldService;
    private final LikedService likedService;
    private final BoughtService boughtService;

    @GetMapping
    public QueryMyInfoResponse queryMyInfo() {
        return myPageService.queryMyPageInfo();
    }

    @GetMapping("/sold")
    public QueryUserPostResponse queryMySold() {
        return soldService.queryMyPageSold();
    }

    @GetMapping("/like")
    public QueryUserPostResponse queryMyLiked() {
        return likedService.queryMyPageLiked();
    }

    @GetMapping("/bought")
    public QueryUserPostResponse queryMyBought() {
        return boughtService.queryMyPageBought();
    }
}
