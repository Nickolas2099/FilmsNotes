package com.example.filmsNotes.domain.response.exception;

import com.example.filmsNotes.domain.constant.Code;
import com.example.filmsNotes.domain.response.error.Error;
import com.example.filmsNotes.domain.response.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException (CustomException ex) {
        log.error("custom error: {}", ex.toString());
        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder()
                .code(ex.getCode())
                .techMessage(ex.getTechMessage())
                .userMessage(ex.getUserMessage())
                .build()).build(), ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedErrorException (Exception ex) {
        log.error("internal server error: {}", ex.toString());
        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder()
                .code(Code.INTERNAL_SERVER_ERROR)
                .userMessage("Внутреняя ошибка сервиса").build())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
