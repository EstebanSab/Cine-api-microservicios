package com.theater.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theater.cinema.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema,Long>{
  
}
