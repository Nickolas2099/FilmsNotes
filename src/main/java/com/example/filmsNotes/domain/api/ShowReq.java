package com.example.filmsNotes.domain.api;

import com.example.filmsNotes.domain.entity.Genre;
import com.example.filmsNotes.domain.entity.Show;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowReq {

    @NotNull(message = "show не должен быть пустым")
    private Show show;
    @NotNull(message = "genres не должен быть пустым")
    @Size(max = 5, message = "должно быть не больше 5 жанров")
    private Set<Genre> genres;

}
