package com.example.bj_isfp_backend.domain.chat.service;

import com.example.bj_isfp_backend.domain.chat.domain.Member;
import com.example.bj_isfp_backend.domain.chat.domain.Message;
import com.example.bj_isfp_backend.domain.chat.domain.Room;
import com.example.bj_isfp_backend.domain.chat.domain.repository.MessageRepository;
import com.example.bj_isfp_backend.domain.chat.facade.MemberFacade;
import com.example.bj_isfp_backend.domain.chat.facade.RoomFacade;
import com.example.bj_isfp_backend.domain.chat.presentation.dto.request.ChatRequest;
import com.example.bj_isfp_backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {


    private final RoomFacade roomFacade;
    private final MemberFacade memberFacade;
    private final MessageRepository messageRepository;

    @Override
    public void saveMessage(ChatRequest chatRequest, User user) {

        Room room = roomFacade.getRoomId(chatRequest.getRoomId());
        Member member = memberFacade.getMemberByUserAndRoom(user, room);

        messageRepository.save(
                Message.builder()
                        .content(chatRequest.getMessage())
                        .room(room)
                        .member(member)
                        .build());
    }
}
