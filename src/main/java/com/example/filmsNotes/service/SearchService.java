package com.example.filmsNotes.service;

import com.example.filmsNotes.domain.entity.Show;
import com.example.filmsNotes.domain.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchService {

    ResponseEntity<Response> searchShowsByNamePart(String namePart);
}
