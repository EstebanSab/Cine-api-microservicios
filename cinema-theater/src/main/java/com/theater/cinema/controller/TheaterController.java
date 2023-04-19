package com.theater.cinema.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.theater.cinema.dto.TheaterDto;
import com.theater.cinema.service.TheaterService;

@RestController
@RequestMapping(path = "/v1/theater")
public class TheaterController {
  
  @Autowired
  private TheaterService theaterService;


  @GetMapping("/{idTheater}")
  public ResponseEntity<TheaterDto> getLocationById(@PathVariable("idTheater") Long idTheater){
    return ResponseEntity.status(HttpStatus.FOUND)
    .body(this.theaterService.getTheaterDtoById(idTheater));
  }

  @GetMapping("/all")
  public ResponseEntity<Set<TheaterDto>> getAllLocations(){
    return ResponseEntity.ok()
    .body(this.theaterService.getAllTheatersDto());
  }


  @PostMapping
  public ResponseEntity<TheaterDto> addNewLocation(@RequestBody TheaterDto newTheater){
    return ResponseEntity.status(HttpStatus.CREATED)
    .body(this.theaterService.createNewTheater(newTheater));
    
  }
}
