package com.date.movie.cinema.model;

import javax.persistence.*;

@Entity(name = "Location")
@Table(
  name = "location")
public class Theater {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(
    name = "id",
    updatable = false,
    nullable = false,
    unique = true
  )
  private Long id;

  private String name;


  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  
}
