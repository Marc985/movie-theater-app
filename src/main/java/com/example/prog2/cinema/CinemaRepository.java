package com.example.prog2.cinema;

import com.example.prog2.Customer.Customer;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql="select * from cinema where id_cinema="+idCinema;
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
    public void addCinema(String title, String releasedate, String duration) {
    String insert="insert into cinema values ('"+title+"','"+releasedate+"','"+duration+"')";
    try (PreparedStatement preparedStatement=connection.prepareStatement(insert)){
        preparedStatement.setString(1,title);
        preparedStatement.setString(2,releasedate);
        preparedStatement.setString(3,duration);
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
