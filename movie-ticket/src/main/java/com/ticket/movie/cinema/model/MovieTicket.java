package com.ticket.movie.cinema.model;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "MovieTicket")
@Table(name = "movie_ticket",
uniqueConstraints ={
  @UniqueConstraint(name="movie_ticket_id_constraint",columnNames ="movie_ticket_id"),
  @UniqueConstraint(name="seat_location_constraint",columnNames ={"seat_row","seat_column","movie_date_theater_id"})}
  )
public class MovieTicket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movie_ticket_id",nullable = false,updatable = false, unique = true)
  private Long movieTicketId;

  @Column(name = "movie_date_theater_id",nullable = false,updatable = false, unique = false)
  private Long movieDateTheaterId;

  @Column(name = "seat_row",nullable = false,updatable = false, unique = false)
  private Integer seatRow;

  @Column(name = "seat_column",nullable = false,updatable = false, unique = false)
  private Integer seatColumn;

}
