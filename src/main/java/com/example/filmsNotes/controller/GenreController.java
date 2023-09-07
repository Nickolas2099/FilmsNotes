package com.example.filmsNotes.controller;

import com.example.filmsNotes.domain.api.GenreReq;
import com.example.filmsNotes.domain.response.Response;
import com.example.filmsNotes.service.genre.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/films-notes/genre")
public class GenreController {

    private final GenreService genreService;

    @GetMapping("/getGenres")
    public ResponseEntity<Response> getGenres() {
        log.info("START endpoint getGenres");
        ResponseEntity<Response> resp = genreService.getGenres();
        log.info("END endpoint getGenres, resp: {}", resp);
        return resp;
    }

    @PostMapping("/updateGenre")
    public ResponseEntity<Response> updateGenre(GenreReq req) {
        log.info("START endpoint updateGenre, req: {}", req);
        ResponseEntity<Response> resp = genreService.updateGenre(req);
        log.info("END endpoint updateGenre, resp: {}", resp);
        return resp;
    }

    @DeleteMapping("/deleteGenre/{id}")
    public ResponseEntity<Response> deleteGenre(@PathVariable("id") Long id) {
        log.info("START endpoint deleteGenre, id: {}", id);
        ResponseEntity<Response> resp = genreService.deleteGenre(id);
        log.info("END endpoint deleteGenre, resp: {}", resp);
        return resp;
    }

}
