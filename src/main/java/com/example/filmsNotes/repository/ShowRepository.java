package com.example.filmsNotes.repository;

import com.example.filmsNotes.domain.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query(value = "SELECT * FROM `show` WHERE LOWER(title) LIKE CONCAT(LOWER(?), '%')" +
            " ORDER BY grade DESC LIMIT 15", nativeQuery = true)
    List<Show> searchShowsByNamePart(String namePart);

}
