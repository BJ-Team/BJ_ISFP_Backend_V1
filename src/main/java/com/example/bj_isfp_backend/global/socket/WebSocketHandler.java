package com.example.bj_isfp_backend.global.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.example.bj_isfp_backend.global.security.jwt.JwtTokenProvider;
import com.example.bj_isfp_backend.global.socket.properties.ClientProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class WebSocketHandler {

    private final JwtTokenProvider jwtTokenProvider;

    public static final ConcurrentHashMap<String, SocketIOClient> socket = new ConcurrentHashMap<>();

    @OnConnect
    public void onConnect(SocketIOClient client) {
        String token = client.getHandshakeData().getSingleUrlParam("Authorization");
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        socket.put(authentication.getName(), client);
        client.set(ClientProperty.USER_KEY, authentication.getName());
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        socket.remove(client.get(ClientProperty.USER_KEY).toString());
    }
}
