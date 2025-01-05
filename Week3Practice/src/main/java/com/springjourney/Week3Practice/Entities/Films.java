package com.springjourney.Week3Practice.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "films")
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmId;

    String filmName;

    String genre;

    String language;

    float imdbRating;

}
