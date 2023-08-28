package com.example.filmsNotes.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "show")
@Data
public class Show {

    @Id
    private Long id;
    private String title;
    private float grade;
    private boolean viewed;
    private int year;
}
