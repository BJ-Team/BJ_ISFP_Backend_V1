package com.example.bj_isfp_backend.domain.chat.service;

import com.example.bj_isfp_backend.domain.chat.presentation.dto.request.ChatRequest;
import com.example.bj_isfp_backend.domain.chat.presentation.dto.response.MessageListResponse;
import com.example.bj_isfp_backend.domain.user.domain.User;

public interface ChatService {
    void saveMessage(ChatRequest chatRequest, User user);

    MessageListResponse queryMessage(Long roomId);
}
