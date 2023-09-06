package com.example.filmsNotes.service.show;

import com.example.filmsNotes.domain.api.ShowReq;
import com.example.filmsNotes.domain.entity.Genre;
import com.example.filmsNotes.domain.entity.Show;
import com.example.filmsNotes.domain.response.Response;
import com.example.filmsNotes.domain.response.SuccessResponse;
import com.example.filmsNotes.domain.utils.Validation;
import com.example.filmsNotes.repository.GenreRepository;
import com.example.filmsNotes.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final Validation validation;
    private final ShowRepository showRepository;
    private final GenreRepository genreRepository;


    @Override
    public ResponseEntity<Response> getShowsWithGenres() {

        List<Show> shows = showRepository.findAllByOrderByGradeDesc();
        return new ResponseEntity<>(SuccessResponse.builder()
                .data(shows)
                .build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getShow(long showId) {
        validation.validationDecimalMin("showId", showId, 1);

        return new ResponseEntity<>(SuccessResponse.builder().data(showRepository.findById(showId)).build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> addShow(ShowReq req) {
        validation.requestValidation(req);

        Iterator<Genre> iterator = req.getShow().getGenres().iterator();

        while (iterator.hasNext()){
            Genre genre = iterator.next();
            if(genreRepository.isGenreExist(genre.getName()) == 1) {
                iterator.remove();
            }
        }
        showRepository.saveAndFlush(req.getShow());
        return new ResponseEntity<>(SuccessResponse.builder().build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> deleteShow(long showId) {
        validation.validationDecimalMin("showId", showId, 1);

        showRepository.deleteById(showId);
        return new ResponseEntity<>(SuccessResponse.builder().build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateShow(ShowReq req) {
        validation.requestValidation(req);

        showRepository.saveAndFlush(req.getShow());
        return new ResponseEntity<>(SuccessResponse.builder().build(), HttpStatus.OK);
    }

}
