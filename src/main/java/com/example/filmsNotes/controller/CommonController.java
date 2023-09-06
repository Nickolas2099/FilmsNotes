package com.example.filmsNotes.controller;

import com.example.filmsNotes.domain.api.ShowReq;
import com.example.filmsNotes.domain.response.Response;
import com.example.filmsNotes.service.show.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/films-notes/show")
@RequiredArgsConstructor
public class CommonController {

    private final ShowService showService;
    @GetMapping("/getShows")
    public ResponseEntity<Response> getShows() {
        log.info("START endpoint getShows");
        ResponseEntity<Response> resp = showService.getShowsWithGenres();
        log.info("END endpoint getShows, resp: {}", resp);
        return resp;
    }

    @GetMapping("/getShow/{id}")
    public ResponseEntity<Response> getShow(@PathVariable("id") long id) {
        log.info("START endpoint getShow, show id: {}", id);
        ResponseEntity<Response> resp = showService.getShow(id);
        log.info("END endpoint getShow, resp: {}", resp);
        return resp;
    }

    @PostMapping("/addShow")
    public ResponseEntity<Response> addShow(@RequestBody final ShowReq req) {
        log.info("START endpoint addShow, req: {}", req);
        ResponseEntity<Response> resp = showService.addShow(req);
        log.info("END endpoint addShow, resp: {}", resp);
        return resp;
    }

    @DeleteMapping("/deleteShow/{id}")
    public ResponseEntity<Response> deleteShow(@PathVariable("id") long id) {
        log.info("START endpoint deleteShow, id: {}", id);
        ResponseEntity<Response> resp = showService.deleteShow(id);
        log.info("END endpoint deleteShow, resp: {}", resp);
        return resp;
    }

    @PatchMapping("/updateShow/{id}")
    public ResponseEntity<Response> updateShow(@PathVariable("id") Long id, @RequestBody final ShowReq req) {
        log.info("START endpoint updateShow, id: {}, req: {}", id, req);
        req.getShow().setId(id);
        ResponseEntity<Response> resp = showService.updateShow(req);
        log.info("END endpoint updateShow, resp: {}", resp);
        return resp;
    }
}
