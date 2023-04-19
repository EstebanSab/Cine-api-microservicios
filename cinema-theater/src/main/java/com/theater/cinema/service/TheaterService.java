package com.theater.cinema.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.cinema.dto.TheaterDto;
import com.theater.cinema.exception.ObjectNotFoundException;
import com.theater.cinema.model.Theater;
import com.theater.cinema.repository.TheaterRepository;

@Service
public class TheaterService {
  
  @Autowired
  private TheaterRepository TheaterRepository;

  @Autowired
  private CinemaService cinemaService;

  public List<Theater> getAllTheater(){
    return this.TheaterRepository.findAll();
  }

  public TheaterDto createNewTheater(TheaterDto newTheaterDto){
    Theater newTheaterToCreate =new Theater();
    newTheaterToCreate.setTheaterNumber(newTheaterDto.getTheaterNumber());
    newTheaterToCreate.setCinema(this.cinemaService.getCinemaById(newTheaterDto.getCinemaId()));
    
    newTheaterToCreate = this.TheaterRepository.save(newTheaterToCreate);
    return this.getTheaterDtoById(newTheaterToCreate.getTheaterId());
  }

  public Theater getTheaterById(Long idTheater){
    return this.TheaterRepository.findById(idTheater).orElseThrow(()->new ObjectNotFoundException("Theater with id: "+idTheater+" Not found"));
  }

  public TheaterDto getTheaterDtoById(Long idTheater){
      Theater miTheater = this.getTheaterById(idTheater);
      TheaterDto theaterDto = new TheaterDto();
      theaterDto.setCinemaId(miTheater.getCinema().getIdCinema());
      theaterDto.setTheaterId(miTheater.getTheaterId());
      theaterDto.setTheaterNumber(miTheater.getTheaterNumber());

      return theaterDto;
  }

}
