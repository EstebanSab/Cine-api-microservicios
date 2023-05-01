package com.ticket.movie.cinema.service;
import java.time.LocalDateTime;

import com.ticket.movie.cinema.model.MovieTicket;

public class BuyTicketThread extends Thread{
  private MovieTicket movieTicket;
  
    @Override
    public void run(){
         System.out.println("Inicio compra");
         try{
            Thread.sleep (5000); 
          }catch (Exception e){}
          System.out.println("Fin compra");
    }

    public void setAlgo(){
      movieTicket.setMovieTicketId((long)1);
    }
}