package com.ticket.movie.cinema.dto;

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
  private String dateAsString;
  private String timeAsString;

}
