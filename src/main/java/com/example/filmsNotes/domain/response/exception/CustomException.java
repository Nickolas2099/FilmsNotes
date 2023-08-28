package com.example.filmsNotes.domain.response.exception;

import com.example.filmsNotes.domain.constant.Code;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class CustomException extends RuntimeException {
    private final Code code;
    private final String techMessage;
    private final String userMessage;
    private final HttpStatus httpStatus;
}
