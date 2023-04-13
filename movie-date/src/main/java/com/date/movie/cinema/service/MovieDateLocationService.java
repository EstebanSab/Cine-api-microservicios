package com.date.movie.cinema.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.movie.cinema.model.MovieDateLocation;
import com.date.movie.cinema.repository.MovieDateLocationRepository;

@Service
public class MovieDateLocationService {
  
  @Autowired
  private MovieDateLocationRepository MovieDateLocationRepository;

  public MovieDateLocation addNewMovieDate(Integer[] newDate,Long idTheater,Long IdMovie){
   
    MovieDateLocation mdl = new MovieDateLocation();
    mdl.setMovieDate(new Date(newDate[0],newDate[1],newDate[2],newDate[3],newDate[4]));
    mdl.setMovieId(IdMovie);
    mdl.setTheaterId(idTheater);
   return  this.MovieDateLocationRepository.save(mdl);

  
  }

  public List<MovieDateLocation> getAllDates(MovieDateLocation newDate){
    return  this.MovieDateLocationRepository.findAll();
   }


}
