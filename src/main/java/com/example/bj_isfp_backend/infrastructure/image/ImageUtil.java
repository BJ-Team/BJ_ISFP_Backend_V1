package com.example.bj_isfp_backend.infrastructure.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUtil {
    String uploadImage(MultipartFile image);
}
