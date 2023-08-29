package com.example.filmsNotes.controller;

import com.example.filmsNotes.domain.entity.Show;
import com.example.filmsNotes.domain.response.Response;
import com.example.filmsNotes.service.ShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/films-notes")
public class ShowController {

    ShowService showService;
    @GetMapping("/getShows")
    public ResponseEntity<Response> getShows() {
        log.info("START endpoint getShows");
        ResponseEntity<Response> resp = showService.getShows();
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
    public ResponseEntity<Response> addShow(@RequestBody Show show) {
        log.info("START endpoint addShow, show: {}", show);
        ResponseEntity<Response> resp = showService.addShow(show);
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

    @PatchMapping("/updateShow")
    public ResponseEntity<Response> updateShow(@RequestBody Show show) {
        log.info("START endpoint updateShow, show: {}", show);
        ResponseEntity<Response> resp = showService.updateShow(show);
        log.info("END endpoint updateShow, resp: {}", resp);
        return resp;
    }
}
