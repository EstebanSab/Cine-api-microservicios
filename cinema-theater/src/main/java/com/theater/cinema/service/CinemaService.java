package com.theater.cinema.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.cinema.dto.CinemaDto;
import com.theater.cinema.dto.TheaterDto;
import com.theater.cinema.exception.ObjectNotFoundException;
import com.theater.cinema.mapper.CinemaMapper;
import com.theater.cinema.mapper.TheaterMapper;
import com.theater.cinema.model.Cinema;
import com.theater.cinema.repository.CinemaRepository;

@Service
public class CinemaService {
  @Autowired
  private CinemaRepository cinemaRepository;

  public CinemaDto createNewCinema(CinemaDto newCinemaDto){
    Cinema newCinema = CinemaMapper.cinemaDtoToCinema(newCinemaDto);
    newCinema = this.cinemaRepository.save(newCinema);
    return CinemaMapper.cinemaToCinemaDto(newCinema);
  }

  public Cinema getCinemaById(Long idCinema){
    return this.cinemaRepository.findById(idCinema).orElseThrow(()->new ObjectNotFoundException("Cinema with id:"+idCinema+" Not found"));
  }

  public CinemaDto getCinemaDtoById(Long idCinema){
    Cinema miCinema = this.getCinemaById(idCinema);
    return CinemaMapper.cinemaToCinemaDto(miCinema);
  }

  public Set<TheaterDto> getTheatersDtoOfCinemaById(Long idCinema) {
    return TheaterMapper.manyTheaterToTheaterDto(this.getCinemaById(idCinema).getTheaters());
  } 

  public Boolean deleteCinemaById(Long idCinema){
    if(this.cinemaRepository.existsById(idCinema)){
      this.cinemaRepository.deleteById(idCinema);
      return true;
    }else{
      throw new ObjectNotFoundException("Cinema with id:"+idCinema+" Not found");
    }
  }
}
