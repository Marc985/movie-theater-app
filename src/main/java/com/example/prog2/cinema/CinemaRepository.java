package com.example.prog2.cinema;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaRepository implements CinemaInterfaceRepository {
    private Connection connection;
    public CinemaRepository(Connection connection){
        this.connection=connection;
    }
    @Override
    public List<Cinema> getCinemaById(int idCinema) {
        String sql="select * from cinema where id_cinema=?";

        List<Cinema> cinema=new ArrayList<>();
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,idCinema);
            ResultSet result=statement.executeQuery();
            while (result.next()){
                convertList(cinema,result);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cinema;
    }


    @Override
    public List<Cinema> getAllCinema() {
        String sql="select * from cinema";
        List<Cinema> cinema=new ArrayList<>();
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            ResultSet result=statement.executeQuery();
            while (result.next()){
                convertList(cinema,result);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cinema;
    }

    @Override
    public List<Cinema> findCinemaByProjectionDate(String date) {
        String sql="select * from cinema inner join project on cinema.id_cinema=project.id_cinema where project_date=?";
        List<Cinema> cinema=new ArrayList<>();
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setString(1,date);
            ResultSet result=statement.executeQuery();
            while (result.next()){
                convertList(cinema,result);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cinema;
    }

    @Override
    public void addCinema(String title, String releaseDate, String duration) {

    }

    @Override
    public void deleteCinemaById(int idCinema) {
        String sql="delete from cinema where id_cinema=?";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,idCinema);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void convertList(List<Cinema> cinemas,ResultSet resultSet) throws Exception{

        cinemas.add(new Cinema(
                resultSet.getInt("id_cinema"),
                resultSet.getString("title"),
                resultSet.getString("release_date"),
                resultSet.getString("duration")
        ));
    }
}
