package com.example.bj_isfp_backend.domain.chat.domain.repository;

import com.example.bj_isfp_backend.domain.chat.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
