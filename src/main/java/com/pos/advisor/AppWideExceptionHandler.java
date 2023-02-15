package com.pos.advisor;

import com.pos.exception.NotFoundExcption;
import com.pos.utill.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundExcption.class)
    public ResponseEntity hanleNotFoundException(NotFoundExcption e){
        return new ResponseEntity(new StandardResponse(404,"Error",e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
