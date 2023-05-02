package com.ticket.movie.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ticket.movie.cinema.dto.MovieDateTheaterDto;

@Service
public class MovieDateTheaterRestService {
  

  @Autowired 
  private RestTemplate restTemplate;

  public Boolean MovieDateTheaterExists(Long movieId){
    Boolean movieExist = this.restTemplate.getForObject("http://localhost:8081/v1/movie/info/exist/"+movieId, Boolean.class);
    return movieExist;
  }

  public MovieDateTheaterDto getMovieDateTheaterById(Long movieDateTheaterId) {
    return new MovieDateTheaterDto((long)1,(long)2,(long)2,"2023-5-2","15-30-00");
  }
}
