package com.example.filmsNotes.service;

import com.example.filmsNotes.domain.api.SearchShowByNamePartReq;
import com.example.filmsNotes.domain.constant.Code;
import com.example.filmsNotes.domain.entity.Show;
import com.example.filmsNotes.domain.response.Response;
import com.example.filmsNotes.domain.response.SuccessResponse;
import com.example.filmsNotes.domain.response.error.Error;
import com.example.filmsNotes.domain.response.error.ErrorResponse;
import com.example.filmsNotes.domain.response.exception.CustomException;
import com.example.filmsNotes.domain.utils.Validation;
import com.example.filmsNotes.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService{

    private final ShowRepository showRepository;
    private final Validation validation;
    @Override
    public ResponseEntity<Response> searchShowsByNamePart(SearchShowByNamePartReq req) {
        String namePart = req.getNamePart().trim();
        if(namePart.equals("")) {
            return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code(Code.EMPTY_REQUEST)
                    .techMessage("namePart должен быть заполнен").build()).build(), HttpStatus.BAD_REQUEST);
        }
        List<Show> shows = showRepository.searchShowsByNamePart(namePart);
        return new ResponseEntity<>(SuccessResponse.builder().data(shows).build(), HttpStatus.OK);
    }
}
