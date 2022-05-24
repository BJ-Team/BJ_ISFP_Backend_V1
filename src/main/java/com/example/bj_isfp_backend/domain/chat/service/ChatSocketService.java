package com.example.bj_isfp_backend.domain.chat.service;

import com.corundumstudio.socketio.SocketIOServer;
import com.example.bj_isfp_backend.domain.chat.domain.Message;
import com.example.bj_isfp_backend.domain.user.domain.User;

public interface ChatSocketService {
    void sendMessage(Message message, User user, Long roomId, SocketIOServer socketIOServer);
}

