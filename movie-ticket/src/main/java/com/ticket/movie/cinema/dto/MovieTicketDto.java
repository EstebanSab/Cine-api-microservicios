package com.ticket.movie.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieTicketDto {
  private Long movieTicketId;
  private String movieName;
  private String cinema;
  private Integer theater;
  private Integer seatRow;
  private Integer seatColumn;
  private String date;
  private String time;

}
