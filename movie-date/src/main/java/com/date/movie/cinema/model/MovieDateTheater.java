package com.date.movie.cinema.model;

import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "MovieDateTheater")
@Table(name = "movie_date_theater",
uniqueConstraints ={
  @UniqueConstraint(name="date_location_constraint",columnNames ={"movie_date","movie_time_start","theater_id"})
})
public class MovieDateTheater {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false, unique = true)
    private Long id;

    @Column(name = "movie_id", updatable = false, nullable = false , unique = false)
    private Long movieId;

    @Column(name = "movie_date", updatable = true, nullable = false, unique = false)
    private LocalDate movieDate;

    @Column(name = "movie_time_start", updatable = true, nullable = false, unique = false)
    private LocalTime movieTimeStart;

    @Column(name = "movie_time_finish", updatable = true, nullable = false, unique = false)
    private LocalTime movieTimeFinish;

    @Column(name = "theater_id", updatable = true, nullable = false , unique = false)
    private Long theaterId;



    
}
