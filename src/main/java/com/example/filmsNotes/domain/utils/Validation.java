package com.example.filmsNotes.domain.utils;

import com.example.filmsNotes.domain.constant.Code;
import com.example.filmsNotes.domain.response.exception.CustomException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class Validation {

    private final Validator validator;

    public <T> void requestValidation(T req) {
        Set<ConstraintViolation<T>> result = validator.validate(req);
        if(!result.isEmpty()) {
            String resultValidations = result.stream()
                    .map(ConstraintViolation::getMessage)
                    .reduce((s1, s2) -> s1 + ". " + s2).orElse("");
            log.error("Переданный в запросе json не валиден, ошибка валидации: {}", resultValidations);
            throw CustomException.builder()
                    .code(Code.REQUEST_VALIDATION_ERROR).techMessage(resultValidations).httpStatus(HttpStatus.BAD_REQUEST).build();
        }
    }

    public void validationDecimalMin(String fieldName, long fieldValue, long constraint) {
        if(fieldValue < constraint) {
            throw CustomException.builder().code(Code.REQUEST_VALIDATION_ERROR)
                    .userMessage(fieldName + " должен быть больше или равен " + constraint)
                    .httpStatus(HttpStatus.BAD_REQUEST).build();
        }
    }

    public void validationDecimalMin(String fieldName, int fieldValue, int constraint) {
        if(fieldValue < constraint) {
            throw CustomException.builder().code(Code.REQUEST_VALIDATION_ERROR)
                    .userMessage(fieldName + " должен быть больше или равен " + constraint)
                    .httpStatus(HttpStatus.BAD_REQUEST).build();
        }
    }

}
