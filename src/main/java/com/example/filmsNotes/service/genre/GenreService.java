package com.example.filmsNotes.service.genre;

import com.example.filmsNotes.domain.api.GenreReq;
import com.example.filmsNotes.domain.entity.Genre;
import com.example.filmsNotes.domain.response.Response;
import org.springframework.http.ResponseEntity;

public interface GenreService {

    ResponseEntity<Response> deleteGenre(Long genreId);
    ResponseEntity<Response> updateGenre(GenreReq genre);
}
