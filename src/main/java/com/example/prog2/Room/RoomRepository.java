package com.example.prog2.Room;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RoomRepository implements  RoomInterfaceRepository{
    private Connection connection;
    public  RoomRepository(Connection connection){
        this.connection=connection;
    }
    @Override
    public List<Room> getAllRoom() {
        String sql="select * from room";
        List<Room> rooms=new ArrayList<>();
        try(PreparedStatement stat=connection.prepareStatement(sql)){
            ResultSet result=stat.executeQuery();
            while (result.next()){
                convertList(rooms,result);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }



        return rooms;
    }

    @Override
    public List<Room> getRoomById(int id_room) {
        String sql="select * from room where id_room="+id_room;
        List<Room> rooms=new ArrayList<>();
        try(PreparedStatement statement=connection.prepareStatement(sql)) {
            ResultSet result=statement.executeQuery();
            while (result.next()){
                convertList(rooms,result);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rooms;
    }
    public void addRoom(String roomName,int capacity) throws Exception{
        String insert="insert into room (room_name, capacity) values (?,?)";
        try (PreparedStatement statement=connection.prepareStatement(insert)){

            statement.setString(1,roomName);
            statement.setInt(2,capacity);
            statement.executeUpdate();
        }


    }
    public  void convertList(List<Room> allRoom,ResultSet result) throws SQLException {
        allRoom.add(new Room(
                result.getInt("id_room"),
                result.getString("room_name"),
                result.getInt("capacity")
        ));
    }
}
