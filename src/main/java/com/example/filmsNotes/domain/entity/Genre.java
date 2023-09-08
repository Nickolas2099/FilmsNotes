package com.example.filmsNotes.domain.entity;

import com.example.filmsNotes.domain.constant.RegExp;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name не должен быть пустым")
    @Pattern(regexp = RegExp.genreName, message = "некорректный name")
    private String name;
    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("genres")
    Set<Show> shows;

    @Override
    public String toString() {
        return id + " " + name;
    }
}
