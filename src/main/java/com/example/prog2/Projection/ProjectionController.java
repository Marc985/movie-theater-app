package com.example.prog2.Projection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectionController {
    private ProjectionService service;
   public ProjectionController(ProjectionService service){
       this.service=service;
   }
   @GetMapping("/projection/{projectionDate}")
   public List<CinemaProjection> findCinemaProjectionByDate(@PathVariable String projectionDate){
      return service.CinemaProjectionByDate(projectionDate);
   }

}
