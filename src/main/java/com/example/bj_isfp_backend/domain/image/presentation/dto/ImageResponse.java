package com.example.bj_isfp_backend.domain.image.presentation.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ImageResponse {

    private final List<String> image;
}
