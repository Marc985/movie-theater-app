package com.example.prog2.Projection;

import java.util.List;

public interface ProjectionInterfaceRepository {
    public List<CinemaProjection> getCinemaProjectionByDate(String projectionDate);

}
