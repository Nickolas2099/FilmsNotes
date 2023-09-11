package com.example.filmsNotes.domain.api;

import com.example.filmsNotes.domain.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenreReq {

    private Genre genre;
}
