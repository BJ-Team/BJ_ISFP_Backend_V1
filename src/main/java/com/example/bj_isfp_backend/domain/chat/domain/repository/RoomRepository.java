package com.example.bj_isfp_backend.domain.chat.domain.repository;

import com.example.bj_isfp_backend.domain.chat.domain.Room;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Long> {
    Optional<Room> findByUserAndPost(User user, Post post);
}
