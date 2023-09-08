package com.example.filmsNotes.repository;

import com.example.filmsNotes.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Modifying
    @Query(value = "INSERT IGNORE INTO genre(name) VALUES(?)", nativeQuery = true)
    void saveGenreIgnore(String name);

    @Query(value = "SELECT EXISTS (SELECT * FROM genre WHERE name = ?);", nativeQuery = true)
    int isGenreExist(String name);

    @Query(value = "SELECT * FROM genre WHERE name = ?", nativeQuery = true)
    Optional<Genre> findIfExist(String name);
}
