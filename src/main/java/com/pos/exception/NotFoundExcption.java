package com.pos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundExcption extends RuntimeException {
    public NotFoundExcption(String message) {
        super(message);
    }
}
