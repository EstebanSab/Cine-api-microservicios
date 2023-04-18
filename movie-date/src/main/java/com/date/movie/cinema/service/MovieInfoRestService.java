package com.date.movie.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.date.movie.cinema.model.MovieInfo;

@Service
public class MovieInfoRestService {
  
  @Autowired 
  private RestTemplate restTemplate;

  public Boolean movieExists(Long movieId){
    Boolean movieExist = this.restTemplate.getForObject("http://localhost:8081/v1/movie/info/exist/"+movieId, Boolean.class);
    return movieExist;
  }

  public Boolean theaterExists(Long theaterId){
    //Boolean theaterExists = this.restTemplate.getForObject("http://localhost:8081/v1/movie/info/exist/"+movieId, Boolean.class);
    return true;
  }

  public MovieInfo getMovieInfoByMovieId(Long movieId){
    return this.restTemplate.getForObject("http://localhost:8081/v1/movie/info/"+movieId, MovieInfo.class);
  }

}
