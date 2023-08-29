package com.example.prog2.Projection;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProjectionRepository implements ProjectionInterfaceRepository{
    private Connection connection;
    public ProjectionRepository(Connection connection){
        this.connection=connection;
    }

    @Override
    public List<CinemaProjection> getCinemaProjectionByDate(String projectionDate) {
        String sql="\n" +
                "select id_project,project_date,hour_project,title,room_name from project inner join cinema on project.id_cinema=cinema.id_cinema\n" +
                "inner join room on project.id_room=room.id_room where project_date=?";
        Date date=Date.valueOf(projectionDate);
        List< CinemaProjection> cinemaProjection=new ArrayList<>();

        try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setDate(1,date);
           ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                ConvertList(cinemaProjection,resultSet);
            };
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cinemaProjection;
    }
    public void ConvertList(List<CinemaProjection> cinemas,ResultSet resultSet) throws Exception{
        cinemas.add(
                new CinemaProjection(
                        resultSet.getInt("id_project"),
                        resultSet.getString("project_date"),
                        resultSet.getString("hour_project"),
                        resultSet.getString("title"),
                        resultSet.getString("room_name")
                )
        );
    }
}
