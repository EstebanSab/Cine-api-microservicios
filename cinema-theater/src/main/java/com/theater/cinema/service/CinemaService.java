package com.theater.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.cinema.model.Cinema;
import com.theater.cinema.repository.CinemaRepository;

@Service
public class CinemaService {
  @Autowired
  private CinemaRepository cinemaRepository;

  public Cinema createNewCinema(){
      Cinema cinema = new Cinema();
      cinema.setNameCinema("New York cinema");
      cinema.setAddress("John stret 212");
      return this.cinemaRepository.save(cinema);
    }

    public Cinema getCinemaById(){
      return this.cinemaRepository.findById((long)1).get();
    }
}
