package com.date.movie.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.date.movie.cinema.model.MovieDateTheater;

public interface MovieDateTheaterRepository extends JpaRepository<MovieDateTheater,Long>{
  
}
