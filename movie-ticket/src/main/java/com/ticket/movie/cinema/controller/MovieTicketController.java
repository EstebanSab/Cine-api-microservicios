package com.ticket.movie.cinema.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ticket.movie.cinema.model.MovieTicket;
import com.ticket.movie.cinema.dto.MovieTicketDto;
import com.ticket.movie.cinema.service.MovieTicketService;

@RestController
@RequestMapping(path = "/v1/movie/ticket")
public class MovieTicketController {
  
  @Autowired
  private MovieTicketService movieTicketService;




  @GetMapping("/{ticketId}")
  public MovieTicketDto getMovieById(@PathVariable("ticketId") Long ticketId){
    return null;
  }



  @PostMapping("/{movieDateTheaterId}")
  public Integer  createNewTicket(@PathVariable("movieDateTheaterId") Long movieDateTheaterId){
    return this.movieTicketService.createNewTicket(movieDateTheaterId);
  }

  @PostMapping("/id/{idTransaction}/seat/row/{row}/column/{column}")
  public Integer  addSeatsToTicket(
    @PathVariable("idTransaction") Integer idTransaction,
    @PathVariable("row") Integer row,
    @PathVariable("column") Integer column){
    return this.movieTicketService.addSeatsToTicket(idTransaction,row,column);
  }


  @PostMapping("/pay/id/{idTransaction}")
  public MovieTicket  payTicket(
    @PathVariable("idTransaction") Integer idTransaction){
    return this.movieTicketService.payTicket(idTransaction);
  }

  @GetMapping("/buylist")
  public Map<Integer,MovieTicket> getAllListMovieTicket(){
    return this.movieTicketService.getAllBuy();
  }
  
 

  }


