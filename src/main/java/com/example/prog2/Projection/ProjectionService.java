package com.example.prog2.Projection;

import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class ProjectionService {
    private ProjectionRepository repository;
    public ProjectionService(ProjectionRepository repository){
        this.repository= repository;
    }
    public List<CinemaProjection> CinemaProjectionByDate(String date){
        return repository.getCinemaProjectionByDate(date);
    }
}
