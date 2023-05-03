package com.ticket.movie.cinema.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.movie.cinema.dto.MovieDateTheaterDto;
import com.ticket.movie.cinema.dto.TheaterSeatsDto;
import com.ticket.movie.cinema.model.MovieTicket;
import com.ticket.movie.cinema.repository.MovieTicketRepository;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


@Service
public class MovieTicketService {

  private Map<Integer,MovieTicket> buyList= new TreeMap<>();
  private Integer idTransaction = 1;
  private MovieDateTheaterDto movieDateTheaterDto;

  @Autowired
  private MovieTicketRepository movieTicketRepository;

  @Autowired
  private MovieDateTheaterRestService movieDateTheaterRestService;


  public void setMovieDateTheaterDto(Long movieDateTheaterId){
    this.movieDateTheaterDto = this.movieDateTheaterRestService.getMovieDateTheaterById(movieDateTheaterId);
  }

  public Map<Integer,TheaterSeatsDto> createNewTicket(Long movieDateTheaterId) {
    this.setMovieDateTheaterDto(movieDateTheaterId);

    MovieTicket movieTicket = new MovieTicket();
    Map<Integer,TheaterSeatsDto> response = new TreeMap<>();


    movieTicket.setMovieDateTheaterId(movieDateTheaterId);


    buyList.put(idTransaction,movieTicket);
    
    this.deleteTransactionAfterTime(idTransaction);
    
    response.put(this.idTransaction++,this.getSeatsOfTheater());

    return response;
  }

  private TheaterSeatsDto getSeatsOfTheater() {
    TheaterSeatsDto theaterSeats = new TheaterSeatsDto();
    
    List<MovieTicket> movieTicketsList =this.movieTicketRepository.findAllByIdOfMovieDateTheater(this.movieDateTheaterDto.getId());
    List<String> seatsOcuppied = new ArrayList<String>();
    //Here i shuould call the cinema theater api to get the data
    //
    //
    theaterSeats.setSeatRow(20);
    theaterSeats.setSeatColumn(20);

    for (MovieTicket movieTicket : movieTicketsList) {
      seatsOcuppied.add(""+movieTicket.getSeatRow()+""+","+""+movieTicket.getSeatColumn());
    }
    
    theaterSeats.setSeatsOcuppied(seatsOcuppied);

    return theaterSeats;
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

  
  public void saveTickets(MovieTicket movieTicket){
    this.movieTicketRepository.save(movieTicket);
  }

}
