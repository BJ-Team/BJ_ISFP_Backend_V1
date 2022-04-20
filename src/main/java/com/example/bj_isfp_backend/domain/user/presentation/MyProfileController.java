package com.example.bj_isfp_backend.domain.user.presentation;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMySoldResponse;
import com.example.bj_isfp_backend.domain.user.service.MyProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mypage")
public class MyProfileController {

    private final MyProfileService profileService;

    @GetMapping
    public QueryMyInfoResponse queryMyInfo() {
        return profileService.queryMyPage();
    }

    @GetMapping("/sold")
    public QueryMySoldResponse querySold() {
        return profileService.queryMySold();
    }
}
