package com.example.prog2.cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@RestController
public class CinemaController {
    private CinemaService service;
    public CinemaController(CinemaService service){
        this.service=service;
    }

    @GetMapping("/cinema/{idCinema}")
    public List<Cinema> findCinemaById(@PathVariable int idCinema){
        return service.getById(idCinema);
    }
    @GetMapping("/cinema")
    public List<Cinema> findAllCinema(){
        return service.getAll();
    }
    @GetMapping("/cinemaProjection/{date}")
      public  List<Cinema> findCinemaByProjecitonDate(@PathVariable String date){
        return service.getByProjectDate(date);
    }
    @PostMapping("/cinema")
    public ResponseEntity<?> addNewCinema(@RequestBody Cinema cinema){
    try {
        service.AddNewCinema(cinema.getTitle(),cinema.getReleaseDate(),cinema.getDuration());
        return ResponseEntity.status(HttpStatus.CREATED).body("new cinema inserted succefully");
    }
    catch (IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.CREATED).body("error:"+e.getMessage());
    }
    catch (Exception e){
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("server error:500");
    }
    }

    @DeleteMapping("/cinema/{idCinema}")
    public String deleteCinemaByid(@PathVariable int idCinema){
       service.deleteOneCinema(idCinema);
       return "deleted succefully";
    }

}
