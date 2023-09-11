package com.example.filmsNotes.domain.response.error;

import com.example.filmsNotes.domain.constant.Code;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private Code code;
    private String techMessage;
    private String userMessage;
}
