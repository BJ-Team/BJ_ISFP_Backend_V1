package com.example.bj_isfp_backend.domain.user.presentation;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryProfileResponse;
import com.example.bj_isfp_backend.domain.user.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public QueryProfileResponse queryProfile(Long userId) {
        return profileService.queryProfile(userId);
    }
}
