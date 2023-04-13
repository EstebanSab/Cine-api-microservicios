package com.date.movie.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.date.movie.cinema.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater,Long>{
  
}
