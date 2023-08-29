package com.example.prog2.Projection;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class CinemaProjection {
 private    int idProject;
   private String projectDate;
   private String projectTime;
   private String title;
   private String room;
}
