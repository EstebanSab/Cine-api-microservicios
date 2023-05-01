package com.info.movie.cinema.model;

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
@Entity(name = "MovieInfo")
@Table(name = "movie_info",
uniqueConstraints ={
  @UniqueConstraint(name="movie_id_constraint",columnNames ="movie_id")}
  )
public class MovieInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movie_id",nullable = false,updatable = false, unique = true)
  private Long movieId;

  @Column(name = "movie_name",nullable = false,updatable = false, unique = true)
  private String movieName;

  @Column(name = "movie_description",nullable = true,updatable = true, unique = false)
  private String movieDescription;

  @Column(name = "movie_duration",nullable = true,updatable = true, unique = false)
  private LocalTime movieDuration;

  @Column(name = "movie_date_release",nullable = true,updatable = true, unique = false)
  private LocalDate movieRelease;
}
