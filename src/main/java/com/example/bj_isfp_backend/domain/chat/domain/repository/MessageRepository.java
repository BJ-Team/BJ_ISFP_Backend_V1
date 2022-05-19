package com.example.bj_isfp_backend.domain.chat.domain.repository;

import com.example.bj_isfp_backend.domain.chat.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
