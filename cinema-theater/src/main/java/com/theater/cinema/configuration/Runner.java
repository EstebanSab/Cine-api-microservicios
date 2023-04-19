package com.theater.cinema.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.theater.cinema.model.Cinema;
import com.theater.cinema.model.Theater;
import com.theater.cinema.service.CinemaService;
import com.theater.cinema.service.TheaterService;

@Component
public class Runner implements CommandLineRunner {

  @Autowired
  private CinemaService cinemaService;

  @Autowired
  private TheaterService theaterService;
  
  @Override
  public void run(String... args) throws Exception {
   /*  Cinema cinema = this.cinemaService.createNewCinema();
   Theater theater = new Theater();
    theater.setCinema(cinema);

    System.out.println(this.theaterService.createNewTheater(theater));
    System.out.println("--------");
    System.out.println("--------");
    System.out.println(this.cinemaService.getCinemaById().getAddress());
    System.out.println(this.cinemaService.getCinemaById().getNameCinema());
    System.out.println(this.cinemaService.getCinemaById().getIdCinema());
    try {
      System.out.println(this.cinemaService.getCinemaById().getTheaters());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
*/
  }
  
}
