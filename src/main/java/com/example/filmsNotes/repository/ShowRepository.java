package com.example.filmsNotes.repository;

import com.example.filmsNotes.domain.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query(value = "SELECT (title, grade, year) FROM `show` WHERE LOWER(title) = CONCAT(LOWER(?), '%') ORDER BY time_insert DESC",
            nativeQuery = true)
    List<Show> searchShowsByNamePart(String namePart);

}
