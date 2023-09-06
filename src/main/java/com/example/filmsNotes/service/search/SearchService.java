package com.example.filmsNotes.service.search;

import com.example.filmsNotes.domain.api.SearchShowByNamePartReq;
import com.example.filmsNotes.domain.entity.Show;
import com.example.filmsNotes.domain.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchService {

    ResponseEntity<Response> searchShowsByNamePart(SearchShowByNamePartReq req);
}
