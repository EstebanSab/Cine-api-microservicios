package com.theater.cinema.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@Entity(name = "Seat")
@Table(name = "seat")
public class Seat {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "seat_id",unique = true, nullable = false ,updatable = false)
  private Long idCinema;

  @Column(name = "seat_row",unique = false, nullable = false ,updatable = false)
  private Integer seatRow;

  @Column(name = "seat_column",unique = false, nullable = false ,updatable = false)
  private Integer seatColumn;

  //occupied mut be in ticket
  //@Column(name = "seat_column",unique = false, nullable = false ,updatable = false)
  //private boolean occupied; 
}
