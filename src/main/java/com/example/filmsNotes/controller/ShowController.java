package com.example.filmsNotes.controller;

import com.example.filmsNotes.domain.api.ShowReq;
import com.example.filmsNotes.domain.entity.Show;
import com.example.filmsNotes.domain.response.Response;
import com.example.filmsNotes.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/films-notes")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;
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

    @PatchMapping("/updateShow")
    public ResponseEntity<Response> updateShow(@RequestBody final ShowReq req) {
        log.info("START endpoint updateShow, req: {}", req);
        ResponseEntity<Response> resp = showService.updateShow(req);
        log.info("END endpoint updateShow, resp: {}", resp);
        return resp;
    }
}
