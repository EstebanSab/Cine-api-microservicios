package com.date.movie.cinema.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.movie.cinema.model.Theater;
import com.date.movie.cinema.repository.TheaterRepository;

@Service
public class TheaterService {
  
  @Autowired
  private TheaterRepository TheaterRepository;

  public List<Theater> getAllTheater(){
    return this.TheaterRepository.findAll();
  }

  public Theater addNewTheater(Theater newTheater){
      return this.TheaterRepository.save(newTheater);
  }

  public Theater getTheaterById(Long idTheater){
    return this.TheaterRepository.findById(idTheater).orElseThrow(()-> new RuntimeException("Theater not found"));
  }

}