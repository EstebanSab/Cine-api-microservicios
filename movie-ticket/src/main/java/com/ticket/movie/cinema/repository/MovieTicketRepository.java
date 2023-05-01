package com.info.movie.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.movie.cinema.model.MovieInfo;

public interface MovieInfoRepository extends JpaRepository<MovieInfo,Long> {
  
}
