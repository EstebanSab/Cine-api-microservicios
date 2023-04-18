package com.theater.cinema.model;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@Setter
@Entity(name = "Cinema")
@Table(name = "cinema")
public class Cinema {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cinema_id",unique = true, nullable = false ,updatable = false)
  private Long idCinema;

  @Column(name = "name_cinema",unique = false, nullable = false ,updatable = false)
  private String nameCinema;

  @Column(name = "address",unique = true, nullable = false ,updatable = true)
  private String address;
  

  @OneToMany(
  mappedBy = "cinema",
  orphanRemoval = true,
  cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  //fetch = FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE)
  private Set<Theater> theaters;
}
