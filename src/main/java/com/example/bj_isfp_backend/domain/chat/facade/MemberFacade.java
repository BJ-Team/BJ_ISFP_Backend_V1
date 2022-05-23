package com.example.bj_isfp_backend.domain.chat.facade;

import com.example.bj_isfp_backend.domain.chat.domain.Member;
import com.example.bj_isfp_backend.domain.chat.domain.Room;
import com.example.bj_isfp_backend.domain.chat.domain.repository.MemberRepository;
import com.example.bj_isfp_backend.domain.chat.exception.MemberNotFoundException;
import com.example.bj_isfp_backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberRepository memberRepository;

    public Member getMemberByUserAndRoom(User user, Room room) {
        return memberRepository.findByUserAndRoom(user, room)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }

    public void isEmptyMessageByUserAndRoom(User user, Room room) {
        if(memberRepository.findByUserAndRoom(user, room).isEmpty())
            throw MemberNotFoundException.EXCEPTION;
    }
}
