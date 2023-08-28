package com.example.filmsNotes.domain.response.error;

import com.example.filmsNotes.domain.response.Response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements Response {
    private Error error;
}
