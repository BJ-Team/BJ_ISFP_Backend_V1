package com.example.bj_isfp_backend.domain.chat.presentation;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.bj_isfp_backend.domain.chat.domain.Message;
import com.example.bj_isfp_backend.domain.chat.presentation.dto.request.ChatRequest;
import com.example.bj_isfp_backend.domain.chat.service.ChatSocketService;
import com.example.bj_isfp_backend.domain.chat.service.MessageService;
import com.example.bj_isfp_backend.domain.chat.service.RoomService;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.global.socket.anotation.SocketController;
import com.example.bj_isfp_backend.global.socket.anotation.SocketMapping;
import lombok.RequiredArgsConstructor;

@SocketController
@RequiredArgsConstructor
public class ChatSocketController {

    private final MessageService messageService;
    private final ChatSocketService chatSocketService;
    private final RoomService roomService;
    private final UserFacade userFacade;

    @SocketMapping(endpoint = "join", requestCls = String.class)
    public void joinRoom(SocketIOClient socketIOClient, SocketIOServer socketIOServer, Long postId) {
        roomService.joinRoom(socketIOClient, socketIOServer, postId);
    }

    @SocketMapping(endpoint = "message", requestCls = ChatRequest.class)
    public void sendMessage(SocketIOClient socketIOClient, SocketIOServer socketIOServer, ChatRequest chatRequest) {

        User user = userFacade.getCurrentUser(socketIOClient);
        Message message = messageService.saveMessage(chatRequest, user);

        chatSocketService.sendMessage(message, user, chatRequest.getRoomId(), socketIOServer);
    }
}
