package com.example.bj_isfp_backend.global.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.example.bj_isfp_backend.infrastructure.s3.S3Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    private S3Properties s3Properties;

    @Bean
    public AmazonS3Client amazonS3Client() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(s3Properties.getIamAccessKey(), s3Properties.getIamSecretKey());
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withRegion(s3Properties.getIamRegion())
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
