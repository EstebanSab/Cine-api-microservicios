package com.date.movie.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.date.movie.cinema.dto.MovieDateTheaterDto;
import com.date.movie.cinema.model.MovieDateTheater;
import com.date.movie.cinema.service.MovieDateTheaterService;

@RestController
@RequestMapping("/v1/movie/date")
public class MovieDateTheaterController {
  
  @Autowired
  private MovieDateTheaterService movieDateTheaterService;

  @GetMapping
  public List<MovieDateTheater> getMovieDateLocationById(){
   return this.movieDateTheaterService.getAllDates();
  }

  @PostMapping()
  public MovieDateTheater addNewMovieDateTheater(@RequestBody MovieDateTheaterDto newMDTdto){
    return this.movieDateTheaterService.addNewMovieDateTheater(newMDTdto);
  }

  @PutMapping()
  public MovieDateTheater updateMovieDateTheater(@RequestBody MovieDateTheaterDto MDTdto){
    return this.movieDateTheaterService.updateMovieDateTheater(MDTdto);
  }

  @DeleteMapping("/{id}")
  public void deleteMovieDateTheater(@PathVariable("id") Long idMDT){
     this.movieDateTheaterService.deleteMovieDateTheaterById(idMDT);
  }
}
