package com.example.bj_isfp_backend.domain.chat.presentation;

import com.example.bj_isfp_backend.domain.chat.presentation.dto.response.MessageListResponse;
import com.example.bj_isfp_backend.domain.chat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final MessageService messageService;

    @GetMapping("/{room-id}")
    public MessageListResponse queryMessage(@PathVariable(name = "room-id") Long roomId) {
        return messageService.queryMessage(roomId);
    }
}
