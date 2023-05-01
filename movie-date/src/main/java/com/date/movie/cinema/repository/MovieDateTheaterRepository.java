package com.date.movie.cinema.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.date.movie.cinema.model.MovieDateTheater;

public interface MovieDateTheaterRepository extends JpaRepository<MovieDateTheater,Long>{
  
    @Transactional
    @Query(value = "Select * from movie_date_theater Where theater_id=?1 and movie_date =?2 and movie_time_finish Between ?3 AND ?4",
    nativeQuery = true)
    MovieDateTheater theaterIsOcupied(Long theaterId,LocalDate movieDate, LocalTime movieTimeStart,LocalTime movieTimeFinish);

    @Transactional
    @Query(value = "Select * from movie_date_theater Where movie_id = ?1",
    nativeQuery = true)
    List<MovieDateTheater> getDateAndLocationByMovieId(Long movieId);


}
