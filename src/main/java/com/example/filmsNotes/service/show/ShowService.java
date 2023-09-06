package com.example.filmsNotes.service.show;

import com.example.filmsNotes.domain.api.ShowReq;
import com.example.filmsNotes.domain.response.Response;
import org.springframework.http.ResponseEntity;

public interface ShowService {
    ResponseEntity<Response> getShowsWithGenres();
    ResponseEntity<Response> getShow(long showId);
    ResponseEntity<Response> addShow(ShowReq req);
    ResponseEntity<Response> deleteShow(long showId);
    ResponseEntity<Response> updateShow(ShowReq req);

}
