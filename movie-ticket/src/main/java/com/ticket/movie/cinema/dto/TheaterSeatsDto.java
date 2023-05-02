package com.ticket.movie.cinema.dto;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeatsDto {
  private Integer seatRow;
  private Integer seatColumn;
  private List<String> seatsOcuppied;
}