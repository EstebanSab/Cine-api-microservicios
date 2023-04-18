package com.date.movie.cinema.mapper;

import java.time.LocalDate;
import java.time.LocalTime;

import com.date.movie.cinema.dto.MovieDateTheaterDto;
import com.date.movie.cinema.model.MovieDateTheater;
import com.date.movie.cinema.model.MovieInfo;

public class MovieDateTheaterMapper {


  
 public static MovieDateTheater mdtDtoToMovieDateTheater(MovieDateTheaterDto movieDateTheaterDto,MovieInfo movieInfo){

  MovieDateTheater movieDateTheater = new MovieDateTheater();

  LocalDate dateMovie = intArrayToLocalDate(movieDateTheaterDto.getDateAsArray());
  LocalTime timeMovieStart = intArrayToLocalTime(movieDateTheaterDto.getTimeAsArray());
  
  int hourFinish=movieInfo.getMovieDuration().getHour() + timeMovieStart.getHour();
  int minuteFinish =movieInfo.getMovieDuration().getMinute() +  timeMovieStart.getMinute();
  
  if(minuteFinish>59){
    minuteFinish = minuteFinish % 60;
    hourFinish++;
  }
  
  if(hourFinish > 23){
    hourFinish = hourFinish % 24;
  }
  LocalTime timeMovieFinish =LocalTime.of(hourFinish, minuteFinish, 0, 0);
  
  movieDateTheater.setMovieTimeFinish(timeMovieFinish);
  movieDateTheater.setMovieDate(dateMovie);
  movieDateTheater.setMovieTimeStart(timeMovieStart);

  movieDateTheater.setMovieId(movieDateTheaterDto.getIdMovie());
  movieDateTheater.setTheaterId(movieDateTheaterDto.getIdTheater());

  return movieDateTheater;
  }

  public static LocalDate intArrayToLocalDate(Integer[] date){
    if(date.length == 3){
      return LocalDate.of(date[0],date[1],date[2]);
    }
    return LocalDate.of(0,0,0);
  }

  public static LocalTime intArrayToLocalTime(Integer[] time){
    if(time.length == 2){
      return LocalTime.of(time[0],time[1], 0, 0);
    }
    return LocalTime.of(0,0, 0, 0);
  }




}
