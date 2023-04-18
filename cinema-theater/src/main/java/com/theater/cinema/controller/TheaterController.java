package com.theater.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.theater.cinema.model.Theater;
import com.theater.cinema.service.TheaterService;

@RestController
@RequestMapping(path = "/location")
public class TheaterController {
  
  @Autowired
  private TheaterService theaterService;


  @GetMapping("/{idLocation}")
  public Theater getLocationById(@PathVariable("idLocation") Long idLocation){
    return this.theaterService.getTheaterById(idLocation);
  }

  @GetMapping
  public List<Theater> getAllLocations(){
    return this.theaterService.getAllTheater();
  }

  @PostMapping
  public Theater addNewLocation(@RequestBody Theater newTheater){
    return this.theaterService.createNewTheater(newTheater);
  }
}
