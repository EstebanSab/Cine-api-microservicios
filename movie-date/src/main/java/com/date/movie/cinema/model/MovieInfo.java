package com.date.movie.cinema.model;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieInfo {
  
  private Long movieId;

  private String movieName;

  private String movieDescription;

  private LocalTime movieDuration;

  private LocalDate movieRelease;
}
