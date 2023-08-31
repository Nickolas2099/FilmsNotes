package com.example.filmsNotes.controller;

import com.example.filmsNotes.domain.response.Response;
import com.example.filmsNotes.service.SearchService;
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
@RequestMapping("films-notes")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/searchShowsByNamePart")
    public ResponseEntity<Response> searchShowsByNamePart(@RequestBody String namePart) {

        log.info("START endpoint searchShowByNamePart, partName: {}", namePart);
        ResponseEntity<Response> resp = searchService.searchShowsByNamePart(namePart);
        log.info("END endpoint searchShowByNamePart, resp: {}", resp);
        return resp;
    }

}
