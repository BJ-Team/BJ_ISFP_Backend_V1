package com.example.bj_isfp_backend.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    BAD_REQUEST(400, "CLIENT-400-1", "Bad Request"),

    UPLOAD_FILE_FAILED(400, "AUTH-400-1", "Upload File Failed"),
    PASSWORD_NOT_CORRECT(409, "AUTH-409-1", "Password Not Correct"),

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    USER_NAME_ALREADY_EXISTS(409, "USER-409-1", "User Name Already Exists"),
    INVALID_USER(401, "USER-401-1", "Invalid User"),

    POST_NOT_FOUND(404, "POST-404-1", "Post Not Found"),
    ALREADY_REPORTED_POST(409, "POST-409-1", "Already Reported Post"),
    ALREADY_SOLD(409, "POST-409-2", "Already Sold"),

    LIFE_NOT_FOUND(404, "LIFE-404-1", "Life Not Found"),

    LIKE_NOT_FOUND(404, "LIKE-404-1", "Like Not Found"),

    NOTIFICATION_NOT_FOUND(404, "NOTIFICATION-404-1", "Notification Not Found"),

    COMMENT_NOT_FOUND(404, "COMMENT-404-1", "Comment Not Found"),

    IMAGE_VALUE_NOT_FOUND(404, "IMAGE-404-1", "Image Value Not Found"),
    SAVE_IMAGE_FAILED(400, "IMAGE-400-1", "Save Image Failed"),

    EXPIRED_JWT(401, "JWT-401-1", "Expired Jwt"),
    INVALID_JWT(401, "JWT-401-2", "Invalid Jwt"),
    REFRESH_TOKEN_NOT_FOUND(404, "JWT-404-1", "RefreshToken Not Found"),

    ROOM_NOT_FOUND(404, "ROOM-404-1", "Room Not Found"),
    ALREADY_JOIN_ROOM(409, "ROOM-409-1", "Already Join Room"),

    MEMBER_NOT_FOUND(404, "MEMBER-404-1", "Member Not Found");

    private final int status;
    private final String code;
    private final String message;
}
