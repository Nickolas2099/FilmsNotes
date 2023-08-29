package com.example.filmsNotes.service;

import com.example.filmsNotes.domain.entity.Show;
import com.example.filmsNotes.domain.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShowService {
    ResponseEntity<Response> getShows();
    ResponseEntity<Response> getShow(long showId);
    ResponseEntity<Response> addShow(Show show);
    ResponseEntity<Response> deleteShow(long showId);
    ResponseEntity<Response> updateShow(Show show);

}
