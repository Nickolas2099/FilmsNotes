package com.example.filmsNotes.domain.api;

import com.example.filmsNotes.domain.constant.RegExp;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchShowByNamePartReq {

    @NotBlank(message = "namePart не должен быть пустым")
    @Pattern(regexp = RegExp.showTitlePart, message = "некорректный namePart")
    String namePart;
}
