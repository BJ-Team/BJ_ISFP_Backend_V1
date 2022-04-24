package com.example.bj_isfp_backend.domain.user.presentation;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryProfileResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryUserPostResponse;
import com.example.bj_isfp_backend.domain.user.service.BoughtService;
import com.example.bj_isfp_backend.domain.user.service.LikedService;
import com.example.bj_isfp_backend.domain.user.service.ProfileService;
import com.example.bj_isfp_backend.domain.user.service.SoldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final SoldService soldService;
    private final LikedService likedService;
    private final BoughtService boughtService;

    @GetMapping("/{user-id}")
    public QueryProfileResponse queryUserProfile(@PathVariable(name = "user-id") Long userId) {
        return profileService.queryProfile(userId);
    }

    @GetMapping("/sold/{user-id}")
    public QueryUserPostResponse queryUserSold(@PathVariable(name = "user-id") Long userId) {
        return soldService.queryUserSold(userId);
    }

    @GetMapping("/like/{user-id}")
    public QueryUserPostResponse queryUserLiked(@PathVariable(name = "user-id") Long userId) {
        return likedService.queryUserLiked(userId);
    }

    @GetMapping("/bought/{user-id}")
    public QueryUserPostResponse queryUserBought(@PathVariable(name = "user-id") Long userId) {
        return boughtService.queryUserBought(userId);
    }
}
