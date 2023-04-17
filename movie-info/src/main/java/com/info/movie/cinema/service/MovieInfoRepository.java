package com.info.movie.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.movie.cinema.model.MovieInfo;

@Service
public class MovieInfoRepository {
  
  @Autowired
  private MovieInfoRepository movieInfoRepository;

  public MovieInfo createNewMovie(){
    return null;
  }

}
