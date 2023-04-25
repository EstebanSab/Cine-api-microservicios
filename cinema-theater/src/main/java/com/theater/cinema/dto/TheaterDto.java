package com.theater.cinema.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TheaterDto {
  private Long theaterId;
  private Integer theaterNumber;
  private Long cinemaId;
  private Integer seatRow;
  private Integer seatColumn;
}
