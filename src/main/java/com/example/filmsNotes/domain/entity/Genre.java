package com.example.filmsNotes.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "genre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    private Long id;
    @NotNull(message = "name не должен быть пустым")
    private String name;
//    @ManyToMany(mappedBy = "genres")
//    private Set<Show> shows;
}
