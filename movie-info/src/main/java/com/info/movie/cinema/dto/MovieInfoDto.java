package com.info.movie.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieInfoDto {
  private Long movieId;
  private String movieName;
  private String movieDescription;
  private String movieDuration;
  private String movieRelease;
}
