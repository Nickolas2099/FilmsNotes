package com.example.filmsNotes.domain.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Entity
@Table(name = "genre")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "name")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name не должен быть пустым")
    private String name;
//    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
//    Set<Show> shows;

    @Override
    public String toString() {
        return id + " " + name;
    }
}
