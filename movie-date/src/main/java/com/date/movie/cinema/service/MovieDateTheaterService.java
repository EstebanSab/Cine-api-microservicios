package com.date.movie.cinema.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.movie.cinema.dto.MovieDateTheaterDto;
import com.date.movie.cinema.model.MovieDateTheater;
import com.date.movie.cinema.repository.MovieDateTheaterRepository;


@Service
public class MovieDateTheaterService {
  
  @Autowired
  private MovieDateTheaterRepository movieDateLocationRepository;

  @Autowired 
  private RestTemplate restTemplate;

  public MovieDateTheater getMovieDateTheaterById(Long id){
    return  this.movieDateLocationRepository.findById(id).orElseThrow(()-> new RuntimeException("not found ------"));
  }

  public List<MovieDateTheater> getAllDates(){
    return  this.movieDateLocationRepository.findAll();
  }

  @Transactional
  public MovieDateTheater addNewMovieDateTheater(MovieDateTheaterDto movieDateTheaterDto){
    
    MovieDateTheater movieDateTheater = new MovieDateTheater();
    
    LocalDate dateMovie = this.intArrayToLocalDate(movieDateTheaterDto.getDateAsArray());
    LocalTime timeMovie = this.intArrayToLocalTime(movieDateTheaterDto.getTimeAsArray());

    movieDateTheater.setMovieDate(dateMovie);
    movieDateTheater.setMovieTime(timeMovie);
    
    Boolean movieExist = this.restTemplate.getForObject("http://localhost:8081/v1/movie/info/exist/"+movieDateTheaterDto.getIdMovie(), Boolean.class);


    if(!movieExist){
      throw new RuntimeException("No existe es pelicula");
    }


    movieDateTheater.setMovieId(movieDateTheaterDto.getIdMovie());
    movieDateTheater.setTheaterId(movieDateTheaterDto.getIdTheater());

    return  this.movieDateLocationRepository.save(movieDateTheater);
  }


  
  public MovieDateTheater updateMovieDateTheater(MovieDateTheaterDto movieDateTheaterDto){
    MovieDateTheater movieDateTheaterToModifier = this.getMovieDateTheaterById(movieDateTheaterDto.getId());

    if(movieDateTheaterDto.getDateAsArray().length == 3){
      LocalDate dateMovie = this.intArrayToLocalDate(movieDateTheaterDto.getDateAsArray());
      movieDateTheaterToModifier.setMovieDate(dateMovie);
    }
    if(movieDateTheaterDto.getTimeAsArray().length == 2){
      LocalTime timeMovie = this.intArrayToLocalTime(movieDateTheaterDto.getTimeAsArray());
      movieDateTheaterToModifier.setMovieTime(timeMovie);
    }
    if(movieDateTheaterDto.getIdMovie() != null && movieDateTheaterDto.getIdMovie() > 0){
      movieDateTheaterToModifier.setMovieId(movieDateTheaterDto.getIdMovie());
    }

    if(movieDateTheaterDto.getIdTheater() != null && movieDateTheaterDto.getIdTheater() > 0){
      movieDateTheaterToModifier.setTheaterId(movieDateTheaterDto.getIdTheater());
    }

    return this.movieDateLocationRepository.save(movieDateTheaterToModifier);
  }

  public void deleteMovieDateTheaterById(Long idMDT) {
   if(this.movieDateLocationRepository.existsById(idMDT)){
    this.movieDateLocationRepository.deleteById(idMDT);
   }
  }

  public LocalDate intArrayToLocalDate(Integer[] date){
    if(date.length == 3){
      return LocalDate.of(date[0],date[1],date[2]);
    }
    return LocalDate.of(0,0,0);
  }

  public LocalTime intArrayToLocalTime(Integer[] time){
    if(time.length == 2){
      return LocalTime.of(time[0],time[1], 0, 0);
    }
    return LocalTime.of(0,0, 0, 0);
  }



 

}
