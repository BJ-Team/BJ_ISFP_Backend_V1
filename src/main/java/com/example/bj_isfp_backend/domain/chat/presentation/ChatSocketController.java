package com.example.bj_isfp_backend.domain.chat.presentation;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.bj_isfp_backend.domain.chat.domain.Message;
import com.example.bj_isfp_backend.domain.chat.presentation.dto.request.ChatRequest;
import com.example.bj_isfp_backend.domain.chat.service.ChatSocketService;
import com.example.bj_isfp_backend.domain.chat.service.MessageService;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.global.socket.anotation.SocketMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/socket")
public class ChatSocketController {

    private final MessageService messageService;
    private final ChatSocketService chatSocketService;
    private final UserFacade userFacade;

    @SocketMapping(endpoint = "message", requestCls = ChatRequest.class)
    public void sendMessage(SocketIOClient socketIOClient, SocketIOServer socketIOServer, ChatRequest chatRequest) {

        User user = userFacade.getCurrentUser(socketIOClient);
        Message message = messageService.saveMessage(chatRequest, user);

        chatSocketService.sendMessage(message, user, chatRequest.getRoomId(), socketIOServer);
    }
}
