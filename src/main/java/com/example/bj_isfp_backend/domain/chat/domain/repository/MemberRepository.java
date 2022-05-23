package com.example.bj_isfp_backend.domain.chat.domain.repository;

import com.example.bj_isfp_backend.domain.chat.domain.Member;
import com.example.bj_isfp_backend.domain.chat.domain.Room;
import com.example.bj_isfp_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByUserAndRoom(User user, Room room);
}
