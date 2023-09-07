package com.example.filmsNotes.repository;

import com.example.filmsNotes.domain.entity.Genre;
import com.example.filmsNotes.domain.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query(value = "SELECT * FROM `show` s WHERE LOWER(s.title) LIKE CONCAT(LOWER(?), '%')" +
            " ORDER BY s.grade DESC LIMIT 15", nativeQuery = true)
    List<Show> searchShowsByNamePart(String namePart);

    List<Show> findAllByOrderByGradeDesc();

    List<Show> findByGenresId(Long genreId);

    @Query(value = "SELECT * FROM `show` s WHERE s.grade >= ?", nativeQuery = true)
    List<Show> searchShowsByMinGrade(float minGrade);
}
