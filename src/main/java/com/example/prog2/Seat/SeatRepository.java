package com.example.prog2.Seat;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatRepository  implements SeatRepositoryInterface{

Connection connection;
public SeatRepository(Connection connection){
    this.connection=connection;
}
    @Override
    public List<Seat> getAvailableSeatByRoomName(String roomName) {
        String sql="select * from seat inner join room on room.id_room=seat.id_room \n" +
                "\n" +
                "where (seat.id_seat not in(\n" +
                "select seat.id_seat from seat inner join reservation on seat.id_seat=reservation.id_seat) and room_name=?)";
        List<Seat> seat=new ArrayList<>();
        try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1,roomName);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
               convertList(seat,resultSet);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  seat;
    }
    public void convertList(List<Seat> seat,ResultSet resultSet) throws Exception{
        seat.add(
                new Seat(
                        resultSet.getInt("id_seat"),
                        resultSet.getInt("seat_number"),
                        resultSet.getString("type")
                )
        );
    }
}
