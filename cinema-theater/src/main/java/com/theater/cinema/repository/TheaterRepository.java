package com.theater.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theater.cinema.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater,Long>{
  
}
