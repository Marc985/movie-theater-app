package com.example.prog2.cinema;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CinemaService {
    private CinemaRepository repository;
    public CinemaService(CinemaRepository repository){
        this.repository=repository;
    }
    public List<Cinema> getById(int idCinema){
        return  repository.getCinemaById(idCinema);
    }
    public List<Cinema> getAll(){
        return repository.getAllCinema();
    }
    public  List<Cinema> getByProjectDate(String date){
        return repository.findCinemaByProjectionDate(date);
    }
    public  void AddNewCinema(String title,String releaseDate,String duration){
        if(title==null||title.trim().isEmpty())
            throw new IllegalArgumentException("the title shouldn't be null");
        if(duration==null||duration.trim().isEmpty())
            throw new IllegalArgumentException("the duration shouldn't be null");
        repository.addCinema(title,releaseDate,duration);

    }
    public void deleteOneCinema(int idCinema){
        repository.deleteCinemaById(idCinema);
    }
}
