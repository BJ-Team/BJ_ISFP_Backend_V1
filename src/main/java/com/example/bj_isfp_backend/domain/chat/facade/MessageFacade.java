package com.example.bj_isfp_backend.domain.chat.facade;

import com.example.bj_isfp_backend.domain.chat.domain.Message;
import com.example.bj_isfp_backend.domain.chat.domain.Room;
import com.example.bj_isfp_backend.domain.chat.domain.repository.MessageRepository;
import com.example.bj_isfp_backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageFacade {

    private final MessageRepository messageRepository;

    public Message saveMessage(User user, Room room) {

    }
}
