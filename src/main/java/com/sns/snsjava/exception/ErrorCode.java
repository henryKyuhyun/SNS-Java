package com.sns.snsjava.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT,"User Name is duplicated"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"Internal server error"),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED,"Password is invalid"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED,"token is invalid"),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND,"Post not founded"),
    INVALID_PERMISSION(HttpStatus.UNAUTHORIZED,"Permission is invalid"),
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurs in database"),

    USER_NOT_FOUNDED(HttpStatus.NOT_FOUND,"User not founded"),
    ALREADY_LIKED(HttpStatus.CONFLICT,"User already liked the post"),
    ALARM_CONNECT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"Connection alarm occurs error")
    ;

    private HttpStatus status;
    private String message;
}
