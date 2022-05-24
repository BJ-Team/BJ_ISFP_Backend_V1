package com.example.bj_isfp_backend.domain.chat.service;

import com.corundumstudio.socketio.SocketIOServer;
import com.example.bj_isfp_backend.domain.chat.domain.Message;
import com.example.bj_isfp_backend.domain.chat.presentation.dto.MessageDto;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.global.socket.properties.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChatSocketServiceImpl implements ChatSocketService {

    @Override
    @Transactional
    public void sendMessage(Message message, User user, Long roomId, SocketIOServer socketIOServer) {
        MessageDto messageDto = MessageDto.builder()
                .roomId(roomId)
                .messageId(message.getId())
                .content(message.getContent())
                .createTime(message.getCreateTime())
                .accountId(user.getAccountId())
                .build();
        socketIOServer.getRoomOperations(String.valueOf(roomId))
                .getClients()
                .forEach(client -> client.sendEvent(SocketProperty.MESSAGE_KEY, messageDto));
    }
}
