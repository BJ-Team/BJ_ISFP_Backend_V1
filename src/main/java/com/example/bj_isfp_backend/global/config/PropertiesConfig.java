package com.example.bj_isfp_backend.global.config;

import com.example.bj_isfp_backend.global.security.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = JwtProperties.class)
@Configuration
public class PropertiesConfig {
}
