package com.date.movie.cinema.model;

import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.*;

@Entity(name = "MovieDateTheater")
@Table(name = "movie_date_theater",
uniqueConstraints ={
  @UniqueConstraint(name="date_location_constraint",columnNames ={"movie_date","movie_time","theater_id"})
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

    @Column(name = "movie_time", updatable = true, nullable = false, unique = false)
    private LocalTime movieTime;

    @Column(name = "theater_id", updatable = true, nullable = false , unique = false)
    private Long theaterId;



    public Long getId() {
      return id;
    }

    public Long getMovieId() {
      return movieId;
    }

    public Long getTheaterId() {
      return theaterId;
    }

    public LocalDate getMovieDate() {
      return movieDate;
    }

    public LocalTime getMovieTime() {
      return movieTime;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public void setMovieId(Long movieId) {
      this.movieId = movieId;
    }

    public void setTheaterId(Long theaterId) {
      this.theaterId = theaterId;
    }

    public void setMovieDate(LocalDate movieDate) {
      this.movieDate = movieDate;
    }
    
    public void setMovieTime(LocalTime movieTime) {
      this.movieTime = movieTime;
    }

    
}
