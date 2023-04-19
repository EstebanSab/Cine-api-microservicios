package com.theater.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.cinema.dto.CinemaDto;
import com.theater.cinema.exception.ObjectNotFoundException;
import com.theater.cinema.model.Cinema;
import com.theater.cinema.repository.CinemaRepository;

@Service
public class CinemaService {
  @Autowired
  private CinemaRepository cinemaRepository;

  public CinemaDto createNewCinema(CinemaDto newCinemaDto){
      Cinema newCinema = new Cinema();
      newCinema.setNameCinema(newCinemaDto.getNameCinema());
      newCinema.setAddress(newCinemaDto.getAddress());

      newCinema = this.cinemaRepository.save(newCinema);
      newCinemaDto.setIdCinema(newCinema.getIdCinema());
      return newCinemaDto;
  }

  public Cinema getCinemaById(Long idCinema){
    return this.cinemaRepository.findById(idCinema).orElseThrow(()->new ObjectNotFoundException("Cinema with id:"+idCinema+" Not found"));
  }

  public CinemaDto getCinemaDtoById(Long idCinema){
    CinemaDto cinemaDto = new CinemaDto();
    Cinema miCinema = this.getCinemaById(idCinema);
    
    cinemaDto.setIdCinema(miCinema.getIdCinema());
    cinemaDto.setAddress(miCinema.getAddress());
    cinemaDto.setNameCinema(miCinema.getNameCinema());
    return cinemaDto;
  } 
}
