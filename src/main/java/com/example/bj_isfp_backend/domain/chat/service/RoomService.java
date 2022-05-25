package com.example.bj_isfp_backend.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;

public interface RoomService {
    void joinRoom(SocketIOClient socketIOClient, SocketIOServer socketIOServer, Long postId);
    void leaveRoom(SocketIOClient socketIOClient, SocketIOServer socketIOServer, Long postId);
}
