package com.theater.cinema.mapper;

import java.util.HashSet;
import java.util.Set;

import com.theater.cinema.dto.CinemaDto;
import com.theater.cinema.model.Cinema;

public class CinemaMapper {
  
  public static CinemaDto cinemaToCinemaDto(Cinema miCinema){
    CinemaDto cinemaDto = new CinemaDto();
    
    
    cinemaDto.setIdCinema(miCinema.getIdCinema());
    cinemaDto.setAddress(miCinema.getAddress());
    cinemaDto.setNameCinema(miCinema.getNameCinema());
    return cinemaDto;
  }


  public static Set<CinemaDto> manyTheaterToTheaterDto(Set<Cinema> manyCinemas){
    Set<CinemaDto> cinemasDtoResponse = new HashSet<>();

    for (Cinema oneCinema : manyCinemas) {
      cinemasDtoResponse.add(cinemaToCinemaDto(oneCinema));
    }
    return cinemasDtoResponse;
  }


  public static Cinema cinemaDtoToCinema(CinemaDto miCinemaDto){
      Cinema newCinema = new Cinema();
      newCinema.setNameCinema(miCinemaDto.getNameCinema());
      newCinema.setAddress(miCinemaDto.getAddress());
      return newCinema;
  }
}
