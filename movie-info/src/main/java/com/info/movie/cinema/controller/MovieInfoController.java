package com.info.movie.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.info.movie.cinema.dto.MovieInfoDto;
import com.info.movie.cinema.model.MovieInfo;
import com.info.movie.cinema.service.MovieInfoService;

@RestController
@RequestMapping(path = "/v1/movie/info")
public class MovieInfoController {
  @Autowired
  private MovieInfoService movieInfoService;



  @GetMapping("/exist/{id}")
  public boolean existMovieById(@PathVariable("id") Long movieId){
    return this.movieInfoService.existMovieById(movieId);
  }


  @GetMapping("/{id}")
  public MovieInfo getMovieById(@PathVariable("id") Long movieId){
    return this.movieInfoService.getMovieById(movieId);
  }

  @GetMapping("/all")
  public List<MovieInfo> getAllMovies(){
    return this.movieInfoService.getAllMovies();
  }

  @PostMapping
  public MovieInfo createNewMovie(@RequestBody MovieInfoDto newMovieInfo){
    return this.movieInfoService.createNewMovie(newMovieInfo);
  }

  @PutMapping
  public MovieInfo updateMovie(@RequestBody MovieInfoDto movieInfo){
    return this.movieInfoService.updateMovie(movieInfo);
  }

  @DeleteMapping("/{id}")
  public void deleteMovie(@PathVariable("id") Long movieId ){
   this.movieInfoService.deleteMovie(movieId);
  }

  }


