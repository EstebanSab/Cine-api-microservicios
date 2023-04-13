package com.date.movie.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.date.movie.cinema.model.MovieDateLocation;

public interface MovieDateLocationRepository extends JpaRepository<MovieDateLocation,Long> {
  
}
