package com.example.bj_isfp_backend.domain.chat.domain.repository;

import com.example.bj_isfp_backend.domain.chat.domain.Message;
import com.example.bj_isfp_backend.domain.chat.domain.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Optional<Message> findByRoom(Room room);
}
