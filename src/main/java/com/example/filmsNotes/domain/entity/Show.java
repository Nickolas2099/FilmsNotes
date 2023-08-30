package com.example.filmsNotes.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "show")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    private Long id;
    @NotNull(message = "title не должен быть пустым")
    private String title;
    @NotNull(message = "grade не должен быть пустым")
    private float grade;
    @NotNull(message = "year не должен быть пустым")
    private int year;
//    @NotNull(message = "genres не должен быть пустым")
//    @ManyToMany
//    @JoinTable(
//            name = "show_genre",
//            joinColumns = @JoinColumn(name = "show_id"),
//            inverseJoinColumns = @JoinColumn(name = "genre_id")
//    )
//    private Set<Genre> genres;
}
