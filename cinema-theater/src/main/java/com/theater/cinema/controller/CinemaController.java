package com.theater.cinema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.theater.cinema.dto.CinemaDto;
import com.theater.cinema.service.CinemaService;

@RestController
@RequestMapping("/v1/cinema")
public class CinemaController {
  
  @Autowired
  private CinemaService cinemaService;

  @GetMapping("/{idCinema}")
  public ResponseEntity<CinemaDto> getCinemaDtoById(@PathVariable("idCinema") Long idCinema){
    return ResponseEntity.ok().body(
      this.cinemaService.getCinemaDtoById(idCinema));
  }

  @PostMapping
  public ResponseEntity<CinemaDto> createNewCinema(@RequestBody CinemaDto newCinemaDto){
    return ResponseEntity.status(HttpStatus.CREATED)
    .body(this.cinemaService.createNewCinema(newCinemaDto));
  }
}
