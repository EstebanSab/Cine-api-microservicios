package com.ticket.movie.cinema.service;


import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.ticket.movie.cinema.dto.MovieDateTheaterDto;
import com.ticket.movie.cinema.dto.MovieTicketDto;
import com.ticket.movie.cinema.model.MovieTicket;
import com.ticket.movie.cinema.repository.MovieTicketRepository;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


@Service
public class MovieTicketService {

  Map<Integer,MovieTicket> buyList= new TreeMap<>();
  Integer idTransaction = 1;

  @Autowired
  private MovieTicketRepository movieTicketRepository;

  //@Autowired
  //private MovieDateTheaterRestService movieDateTheaterRestService;

  public MovieTicketDto getMovieTicketDtoResponse(MovieTicket movieTicket){
    //MovieDateTheaterDto movieDateTheaterDto = this.movieDateTheaterRestService.getMovieDateTheaterById(movieTicket.getMovieDateTheaterId());
    return null;

  }

  public Integer createNewTicket(Long movieDateTheaterId) {
    MovieTicket movieTicket = new MovieTicket();
    movieTicket.setMovieDateTheaterId(movieDateTheaterId);

    buyList.put(idTransaction,movieTicket);
    
    this.deleteTransactionAfterTime(idTransaction);

    return idTransaction++; 
  }

  public Map<Integer,MovieTicket> getAllBuy() {
    return this.buyList;
  }

  public Integer addSeatsToTicket(Integer idTransaction, Integer row, Integer column) {
   buyList.get(idTransaction).setSeatRow(row);
   buyList.get(idTransaction).setSeatColumn(column);
  
   return idTransaction;
  }

  public MovieTicket payTicket(Integer idTransaction) {
   return this.movieTicketRepository.save(this.buyList.get(idTransaction));
  }

  public void deleteTransactionAfterTime(Integer idTransaction){
    Timer timer = new Timer(100000, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        buyList.remove(idTransaction);
      }
  });

  timer.setRepeats(false);
  timer.start();
  }

 

}
