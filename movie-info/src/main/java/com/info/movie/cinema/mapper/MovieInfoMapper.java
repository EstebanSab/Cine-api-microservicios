package com.info.movie.cinema.mapper;

import com.info.movie.cinema.dto.MovieInfoDto;
import com.info.movie.cinema.model.MovieInfo;



import java.time.LocalDate;
import java.time.LocalTime;


public  class MovieInfoMapper {
  public static MovieInfo movieInfoDtoToMovieInfo(MovieInfoDto movieInfoDto){
    MovieInfo movieInfo = new MovieInfo();
    movieInfo.setMovieName(movieInfoDto.getMovieName());
    movieInfo.setMovieDescription(movieInfoDto.getMovieDescription());
    
    movieInfo.setMovieDuration(
      MovieInfoMapper.stringToLocalTime(movieInfoDto.getMovieDuration()));

    movieInfo.setMovieRelease(
      MovieInfoMapper.stringToLocalDate(movieInfoDto.getMovieRelease()));


    return movieInfo;
  }





  public static LocalDate stringToLocalDate(String date){
    String dates[] = date.split("-");

    if(dates.length == 3){
      return LocalDate.of(Integer.parseInt(dates[0]),Integer.parseInt(dates[1]),Integer.parseInt(dates[2]));
    }
    return LocalDate.of(0,0,0);
  }

  public  static LocalTime stringToLocalTime(String time){
    String times[] = time.split("-");

    if(times.length == 2){
      return LocalTime.of(Integer.parseInt(times[0]),Integer.parseInt(times[1]),0,0);
    }
    
    return LocalTime.of(0,0, 0, 0);
  }
}
