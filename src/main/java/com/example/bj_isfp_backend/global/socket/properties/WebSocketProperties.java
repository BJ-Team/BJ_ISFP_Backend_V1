package com.example.bj_isfp_backend.global.socket.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "socket")
public class WebSocketProperties {

    private final String host;
    private final Integer port;

    public WebSocketProperties(String host, Integer port) {
        this.host = host;
        this.port = port;
    }
}
