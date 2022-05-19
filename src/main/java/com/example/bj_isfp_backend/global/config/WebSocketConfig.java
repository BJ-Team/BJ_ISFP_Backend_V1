package com.example.bj_isfp_backend.global.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import com.example.bj_isfp_backend.global.socket.exception.SocketExceptionListener;
import com.example.bj_isfp_backend.global.socket.properties.WebSocketProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WebSocketConfig {

    private final WebSocketProperties webSocketProperties;

    @Bean
    public SocketIOServer socketIOServer() {
        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setSocketConfig(socketConfig);
        config.setHostname(webSocketProperties.getHost());
        config.setPort(webSocketProperties.getPort());
        config.setOrigin("*");
        config.setExceptionListener(new SocketExceptionListener());
        return new SocketIOServer(config);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner() {
        return new SpringAnnotationScanner(socketIOServer());
    }
}
