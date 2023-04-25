package com.theater.cinema.mapper;

import java.util.HashSet;
import java.util.Set;

import com.theater.cinema.dto.TheaterDto;
import com.theater.cinema.model.Theater;

public class TheaterMapper {
  public static TheaterDto theaterToTheaterDto(Theater theater){
    TheaterDto theaterDtoResponse = new TheaterDto();
    theaterDtoResponse.setCinemaId(theater.getCinema().getIdCinema());
    theaterDtoResponse.setTheaterId(theater.getTheaterId());
    theaterDtoResponse.setTheaterNumber(theater.getTheaterNumber());
    theaterDtoResponse.setSeatColumn(theater.getSeatColumn());
    theaterDtoResponse.setSeatRow(theater.getSeatRow());
    return theaterDtoResponse;
  }

  public static Set<TheaterDto> manyTheaterToTheaterDto( Set<Theater> manyTheaters){
      Set<TheaterDto> theatersDtoResponse = new HashSet<>();

      for (Theater oneTheater : manyTheaters) {
        theatersDtoResponse.add(theaterToTheaterDto(oneTheater));
      }
  return theatersDtoResponse;
    }
}
