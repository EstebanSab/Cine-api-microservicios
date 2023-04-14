package com.date.movie.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDateTheaterDto {
  private Long id;
  private Long idMovie;
  private Long idTheater;
  private Integer[] dateAsArray;
  private Integer[] timeAsArray;

}
