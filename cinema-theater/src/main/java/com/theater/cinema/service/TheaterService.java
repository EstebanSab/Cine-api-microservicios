package com.theater.cinema.service;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.cinema.dto.TheaterDto;
import com.theater.cinema.exception.ObjectNotFoundException;
import com.theater.cinema.mapper.TheaterMapper;
import com.theater.cinema.model.Theater;
import com.theater.cinema.repository.TheaterRepository;

@Service
public class TheaterService {
  
  @Autowired
  private TheaterRepository TheaterRepository;

  @Autowired
  private CinemaService cinemaService;

  public Set<TheaterDto> getAllTheatersDto(){
    Set<Theater> allTheaters =  this.TheaterRepository.findAll().stream().collect(Collectors.toSet());
  
    //Set<String> set = new HashSet<>(list);
    //set.addAll(list);
    //set = list.stream().collect(Collectors.toSet());
    return TheaterMapper.manyTheaterToTheaterDto(allTheaters);
 }
  
  

  public TheaterDto createNewTheater(TheaterDto newTheaterDto){
    Theater newTheaterToCreate =new Theater();
    newTheaterToCreate.setTheaterNumber(newTheaterDto.getTheaterNumber());
    newTheaterToCreate.setCinema(this.cinemaService.getCinemaById(newTheaterDto.getCinemaId()));
    newTheaterToCreate.setSeatRow(newTheaterDto.getSeatRow());
    newTheaterDto.setSeatColumn(newTheaterDto.getSeatColumn());

    newTheaterToCreate = this.TheaterRepository.save(newTheaterToCreate);
    return this.getTheaterDtoById(newTheaterToCreate.getTheaterId());
  }

  public Theater getTheaterById(Long idTheater){
    return this.TheaterRepository.findById(idTheater).orElseThrow(()->new ObjectNotFoundException("Theater with id: "+idTheater+" Not found"));
  }

  public TheaterDto getTheaterDtoById(Long idTheater){
    
      Theater miTheater = this.getTheaterById(idTheater);
      return TheaterMapper.theaterToTheaterDto(miTheater);

  }

}
