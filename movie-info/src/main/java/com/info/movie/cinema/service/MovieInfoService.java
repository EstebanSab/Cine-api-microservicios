package com.info.movie.cinema.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.movie.cinema.dto.MovieInfoDto;
import com.info.movie.cinema.mapper.MovieInfoMapper;
import com.info.movie.cinema.model.MovieInfo;
import com.info.movie.cinema.repository.MovieInfoRepository;

@Service
public class MovieInfoService {
  
  @Autowired
  private MovieInfoRepository movieInfoRepository;


  public MovieInfo getMovieById(Long movieId){
    return this.movieInfoRepository.findById(movieId).get();
  }

  public List<MovieInfo> getAllMovies(){
    return this.movieInfoRepository.findAll();
  }

  public Boolean existMovieById(Long movieId){
    return this.movieInfoRepository.existsById(movieId);
  }

  public MovieInfo createNewMovie(MovieInfoDto movieInfoDto){
   MovieInfo movieInfo = MovieInfoMapper.movieInfoDtoToMovieInfo(movieInfoDto);
    
    return this.movieInfoRepository.save(movieInfo);
  }

  public MovieInfo updateMovie(MovieInfoDto movieInfoDto){
    MovieInfo movieInfo = MovieInfoMapper.movieInfoDtoToMovieInfo(movieInfoDto);
    movieInfo.setMovieId(movieInfoDto.getMovieId());
    return this.movieInfoRepository.save(movieInfo);
  }

  public void deleteMovie(Long movieId){
    this.movieInfoRepository.deleteById(movieId);
  }

 

}
