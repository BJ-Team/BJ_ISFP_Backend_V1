package com.example.bj_isfp_backend.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.bj_isfp_backend.domain.chat.domain.Member;
import com.example.bj_isfp_backend.domain.chat.domain.Message;
import com.example.bj_isfp_backend.domain.chat.domain.Room;
import com.example.bj_isfp_backend.domain.chat.domain.repository.MemberRepository;
import com.example.bj_isfp_backend.domain.chat.domain.repository.MessageRepository;
import com.example.bj_isfp_backend.domain.chat.domain.repository.RoomRepository;
import com.example.bj_isfp_backend.domain.chat.facade.RoomFacade;
import com.example.bj_isfp_backend.domain.chat.presentation.dto.MessageDto;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.post.facade.PostFacade;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.global.socket.properties.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {

    private final UserFacade userFacade;
    private final PostFacade postFacade;
    private final RoomFacade roomFacade;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;
    private final MessageRepository messageRepository;

    @Override
    @Transactional
    public void joinRoom(SocketIOClient socketIOClient, SocketIOServer socketIOServer, Long postId) {

        User user = userFacade.getCurrentUser(socketIOClient);

        Post post = postFacade.getPostById(postId);

        roomFacade.AlreadyJoinRoom(user, post);

        Room room = roomRepository.save(
                Room.builder()
                        .post(post)
                        .user(user)
                        .postImage(post.getPostImage())
                        .build());

        Member member = memberRepository.save(
                Member.builder()
                        .user(user)
                        .room(room)
                        .build());

        Message message = messageRepository.save(
                Message.builder()
                        .content(user.getName() + "님이 입장하셨습니다.")
                        .member(member)
                        .room(room)
                        .build());

        socketIOClient.joinRoom(String.valueOf(room.getId()));
        sendEvent(socketIOClient, socketIOServer, message, user, room.getId());
    }

    private void sendEvent(SocketIOClient socketIOClient, SocketIOServer socketIOServer, Message message, User user, Long roomId) {
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

        socketIOClient.sendEvent(SocketProperty.ROOM_KEY, roomId);
    }
}
