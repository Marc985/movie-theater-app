package com.example.prog2.cinema;

import java.util.List;

public interface CinemaInterfaceRepository {
    public List<Cinema> getCinemaById(int idCinema);
    public List<Cinema> getAllCinema();
    public void addCinema(String title,String releaseDate,String duration);
}
