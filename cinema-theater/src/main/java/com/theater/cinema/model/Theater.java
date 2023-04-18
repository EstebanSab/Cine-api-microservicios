package com.theater.cinema.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "Location")
@Table(
  name = "location")
public class Theater {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(
    name = "id",updatable = false,nullable = false,unique = true
  )
  private Long id;

 
    //cinema have many theaters
    //Theater is in only one cinema
    //so theater is going to have the extra column
    //with the primary key of cinema
    @ManyToOne
    @JoinColumn(
            name = "cinema_id",
            nullable = false,
            referencedColumnName = "cinema_id",
            foreignKey = @ForeignKey(
                    name = "cinema_id_fk"
            )
    )
    private Cinema cinema;
  
}
