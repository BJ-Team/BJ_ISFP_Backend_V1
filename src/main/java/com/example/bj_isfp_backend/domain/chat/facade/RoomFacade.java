package com.example.bj_isfp_backend.domain.chat.facade;

import com.example.bj_isfp_backend.domain.chat.domain.repository.RoomRepository;
import com.example.bj_isfp_backend.domain.chat.exception.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomFacade {

    private final RoomRepository roomRepository;

    public void getRoomId(Long roomId) {
        roomRepository.findById(roomId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }
}
