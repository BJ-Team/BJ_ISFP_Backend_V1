package com.example.bj_isfp_backend.domain.chat.service;

import com.example.bj_isfp_backend.domain.chat.domain.Member;
import com.example.bj_isfp_backend.domain.chat.domain.Message;
import com.example.bj_isfp_backend.domain.chat.domain.Room;
import com.example.bj_isfp_backend.domain.chat.domain.repository.MessageRepository;
import com.example.bj_isfp_backend.domain.chat.domain.repository.RoomRepository;
import com.example.bj_isfp_backend.domain.chat.exception.RoomNotFoundException;
import com.example.bj_isfp_backend.domain.chat.facade.MemberFacade;
import com.example.bj_isfp_backend.domain.chat.facade.RoomFacade;
import com.example.bj_isfp_backend.domain.chat.presentation.dto.request.ChatRequest;
import com.example.bj_isfp_backend.domain.chat.presentation.dto.response.MessageListResponse;
import com.example.bj_isfp_backend.domain.chat.presentation.dto.response.MessageListResponse.MessageResponse;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MemberFacade memberFacade;
    private final UserFacade userFacade;
    private final RoomFacade roomFacade;
    private final MessageRepository messageRepository;

    @Override
    @Transactional
    public Message saveMessage(ChatRequest chatRequest, User user) {

        Room room = roomFacade.getRoomId(chatRequest.getRoomId());
        Member member = memberFacade.getMemberByUserAndRoom(user, room);

        return messageRepository.save(
                Message.builder()
                        .content(chatRequest.getMessage())
                        .member(member)
                        .room(room)
                        .build());
    }

    @Override
    @Transactional(readOnly = true)
    public MessageListResponse queryMessage(Long roomId) {

        User user = userFacade.getCurrentUser();
        Room room = roomFacade.getRoomId(roomId);

        memberFacade.isEmptyMessageByUserAndRoom(user, room);

        List<MessageResponse> messageResponseList = messageRepository.findByRoom(room)
                .stream()
                .map(this::messageBuilder)
                .collect(Collectors.toList());

        return MessageListResponse.builder()
                .messageResponseList(messageResponseList)
                .build();
    }

    private MessageResponse messageBuilder(Message message) {
        return MessageResponse.builder()
                .messageId(message.getId())
                .content(message.getContent())
                .createTime(message.getCreateTime())
                .member(message.getMember())
                .room(message.getRoom())
                .build();
    }
}
