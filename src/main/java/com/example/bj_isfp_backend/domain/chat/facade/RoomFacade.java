package com.example.bj_isfp_backend.domain.chat.facade;

import com.example.bj_isfp_backend.domain.chat.domain.Room;
import com.example.bj_isfp_backend.domain.chat.domain.repository.RoomRepository;
import com.example.bj_isfp_backend.domain.chat.exception.AlreadyJoinRoomException;
import com.example.bj_isfp_backend.domain.chat.exception.RoomNotFoundException;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomFacade {

    private final RoomRepository roomRepository;

    public Room getRoomId(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }

    public void AlreadyJoinRoom(User user, Post post) {
        if (roomRepository.findByUserAndPost(user, post).isPresent())
            throw AlreadyJoinRoomException.EXCEPTION;
    }
}
