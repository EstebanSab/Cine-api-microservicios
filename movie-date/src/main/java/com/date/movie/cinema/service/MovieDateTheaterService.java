package com.date.movie.cinema.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.movie.cinema.dto.MovieDateTheaterDto;
import com.date.movie.cinema.mapper.MovieDateTheaterMapper;
import com.date.movie.cinema.model.MovieDateTheater;
import com.date.movie.cinema.model.MovieInfo;
import com.date.movie.cinema.repository.MovieDateTheaterRepository;
import com.date.movie.cinema.exception.*;

@Service
public class MovieDateTheaterService {
  
  @Autowired
  private MovieDateTheaterRepository movieDateLocationRepository;

  @Autowired 
  private MovieInfoRestService movieInfoRestService;


  public MovieDateTheater getMovieDateTheaterById(Long id){
    return  this.movieDateLocationRepository.findById(id).orElseThrow(()-> new RuntimeException("not found ------"));
  }

  public List<MovieDateTheater> getAllDates(){
    return  this.movieDateLocationRepository.findAll();
  }


  public MovieDateTheater addNewMovieDateTheater(MovieDateTheaterDto movieDateTheaterDto){

    Boolean movieExist =this.movieInfoRestService.movieExists(movieDateTheaterDto.getIdMovie());
    Boolean theaterExist = this.movieInfoRestService.theaterExists(movieDateTheaterDto.getIdTheater());
    
    if(!movieExist){
      throw new ObjectNotFoundException("Does not exist any movie with that id");
    }

    if(!theaterExist){
      throw new RuntimeException("Does not exist any theater with that id");
    }
    
    MovieInfo movieInfo = this.movieInfoRestService.getMovieInfoByMovieId(movieDateTheaterDto.getIdMovie());
    MovieDateTheater movieDateTheater = MovieDateTheaterMapper.mdtDtoToMovieDateTheater(movieDateTheaterDto, movieInfo);

    this.theaterInTimeAndDateIsOcuppied(movieDateTheater.getTheaterId(),movieDateTheater.getMovieDate(),movieDateTheater.getMovieTimeStart(),movieDateTheater.getMovieTimeFinish());
    
    return  this.movieDateLocationRepository.save(movieDateTheater);
  }



  public void theaterInTimeAndDateIsOcuppied(Long theaterId,LocalDate dateMovie,LocalTime timeMovie,LocalTime timeMovieFinish){
    MovieDateTheater movieDateIsOcuppied = this.movieDateLocationRepository.theaterIsOcupied(theaterId,dateMovie,timeMovie,timeMovieFinish);
    
    if(movieDateIsOcuppied != null){
      throw new DateTimeTheaterException("This teather is occupied in this Time");
    }
  }
  
  /*public MovieDateTheater updateMovieDateTheater(MovieDateTheaterDto movieDateTheaterDto){
    MovieDateTheater movieDateTheaterToModifier = this.getMovieDateTheaterById(movieDateTheaterDto.getId());

    if(movieDateTheaterDto.getDateAsArray().length == 3){
      LocalDate dateMovie = this.intArrayToLocalDate(movieDateTheaterDto.getDateAsArray());
      movieDateTheaterToModifier.setMovieDate(dateMovie);
    }
    if(movieDateTheaterDto.getTimeAsArray().length == 2){
      LocalTime timeMovie = this.intArrayToLocalTime(movieDateTheaterDto.getTimeAsArray());
      movieDateTheaterToModifier.setMovieTimeStart(timeMovie);
    }
    if(movieDateTheaterDto.getIdMovie() != null && movieDateTheaterDto.getIdMovie() > 0){
      movieDateTheaterToModifier.setMovieId(movieDateTheaterDto.getIdMovie());
    }

    if(movieDateTheaterDto.getIdTheater() != null && movieDateTheaterDto.getIdTheater() > 0){
      movieDateTheaterToModifier.setTheaterId(movieDateTheaterDto.getIdTheater());
    }

    return this.movieDateLocationRepository.save(movieDateTheaterToModifier);
  }*/

  public void deleteMovieDateTheaterById(Long idMDT) {
   if(this.movieDateLocationRepository.existsById(idMDT)){
    this.movieDateLocationRepository.deleteById(idMDT);
   }
  }


 

}
