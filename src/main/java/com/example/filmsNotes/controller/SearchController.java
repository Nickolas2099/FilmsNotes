package com.example.filmsNotes.controller;

import com.example.filmsNotes.domain.api.GenreReq;
import com.example.filmsNotes.domain.api.SearchShowByNamePartReq;
import com.example.filmsNotes.domain.response.Response;
import com.example.filmsNotes.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("films-notes/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/searchShowsByNamePart")
    public ResponseEntity<Response> searchShowsByNamePart(@RequestBody SearchShowByNamePartReq req) {

        log.info("START endpoint searchShowByNamePart, req: {}", req);
        ResponseEntity<Response> resp = searchService.searchShowsByNamePart(req);
        log.info("END endpoint searchShowByNamePart, resp: {}", resp);
        return resp;
    }

    @GetMapping("/searchShowsByGenre")
    public ResponseEntity<Response> searchShowByGenre(@RequestBody GenreReq req) {

        log.info("START endpoint searchShowByGenre, req: {}", req);
        ResponseEntity<Response> resp = searchService.searchShowsByGenre(req);
        log.info("END endpoint searchShowByGenre, resp: {}", req);
        return resp;
    }

    @GetMapping("/searchShowsByMinGrade")
    public ResponseEntity<Response> searchShowsByMinGrade(@RequestBody float minGrade) {

        log.info("START endpoint searchShowsByMinGrade, minGrade: {}", minGrade);
        ResponseEntity<Response> resp = searchService.searchShowsByMinGrade(minGrade);
        log.info("END endpoint searchShowsByMinGrade, resp: {}", resp);
        return resp;
    }
}
