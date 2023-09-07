package com.example.filmsNotes.service.genre;

import com.example.filmsNotes.domain.api.GenreReq;
import com.example.filmsNotes.domain.entity.Genre;
import com.example.filmsNotes.domain.response.Response;
import com.example.filmsNotes.domain.response.SuccessResponse;
import com.example.filmsNotes.domain.utils.Validation;
import com.example.filmsNotes.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final Validation validation;
    private final GenreRepository genreRepository;

    @Override
    public ResponseEntity<Response> getGenres() {
        List<Genre> genres = genreRepository.findAll();
        return new ResponseEntity<>(SuccessResponse.builder().data(genres).build(), HttpStatus.OK);
    }

    public ResponseEntity<Response> deleteGenre(Long genreId) {
        validation.validationDecimalMin("genreId", genreId, 1);

        genreRepository.deleteById(genreId);
        return new ResponseEntity<>(SuccessResponse.builder().build(), HttpStatus.OK);
    }

    public ResponseEntity<Response> updateGenre(GenreReq req) {
        validation.requestValidation(req);

        genreRepository.saveAndFlush(req.getGenre());
        return new ResponseEntity<>(SuccessResponse.builder().build(), HttpStatus.OK);
    }

}
