package com.example.bj_isfp_backend.infrastructure.s3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "aws.s3")
public class S3Properties {

    private final String iamAccessKey;
    private final String iamSecretKey;
    private final String bucket;
    private final String iamRegion;
}
