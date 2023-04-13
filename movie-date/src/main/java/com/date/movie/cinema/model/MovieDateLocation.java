package com.date.movie.cinema.model;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "Date")
@Table(name = "date",
uniqueConstraints ={
  @UniqueConstraint(name="date_theater_constraint",columnNames ={"movie_date","theater_id"})
})
public class MovieDateLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
      name = "id",
      unique = true,
      nullable = false,
      updatable = false
    )
    private Long id;


    @Column(name = "movie_id", updatable = false, nullable = false , unique = false)
    private Long movieId;


    
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date utilDate;

    @Column(name = "movie_date", updatable = true, nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date movieDate;

    @Column(name = "theater_id", updatable = true, nullable = false , unique = false)
    private Long theaterId;



    public Long getId() {
      return id;
    }

    public Date getMovieDate() {
      return movieDate;
    }

    public Long getMovieId() {
      return movieId;
    }

    public Long getTheaterId() {
      return theaterId;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public void setMovieDate(Date movieDate) {
      this.movieDate = movieDate;
    }

    public void setMovieId(Long movieId) {
      this.movieId = movieId;
    }

    public void setTheaterId(Long theaterId) {
      this.theaterId = theaterId;
    }

 

    
}
