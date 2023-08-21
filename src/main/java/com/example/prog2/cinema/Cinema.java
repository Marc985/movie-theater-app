package com.example.prog2.cinema;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cinema {
  private   int idCinema;
   private String title;
   private String releaseDate;
   private String duration;
}
