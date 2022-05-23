package com.example.bj_isfp_backend.domain.chat.presentation.dto.response;

import com.example.bj_isfp_backend.domain.chat.domain.Member;
import com.example.bj_isfp_backend.domain.chat.domain.Room;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class MessageListResponse {

    private final List<MessageResponse> messageResponseList;

    @Getter
    @Builder
    public static class MessageResponse {
        private final Long messageId;
        private final String content;
        private final LocalDateTime createTime;
        private final Member member;
        private final Room room;
    }
}
