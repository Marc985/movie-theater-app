package com.example.prog2.Reservation;

import com.example.prog2.Customer.Customer;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepository implements ReservationInterfaceRepository {
    private Connection connection;
    public ReservationRepository(Connection connection){
        this.connection=connection;
    }
    @Override
    public List<CustomerReservation> getAllCustomersReservation() {
        String sql="  select customer_first_name,customer_last_name,email,reservation_date,seat_number,room_name from customer " +
                "inner join reservation on reservation.id_customer=customer.id_customer\n" +
                "inner join seat on reservation.id_seat=seat.id_seat inner join room on room.id_room=seat.id_room;";
        List<CustomerReservation> customers=new ArrayList<>();
        try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
               ConvertToList(customers,resultSet);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public List<CustomerReservation> getReservationByIdCustomer(int idCustomer) {
        String sql="  select customer_first_name,customer_last_name,email,reservation_date,seat_number,room_name from customer " +
                "inner join reservation on reservation.id_customer=customer.id_customer\n" +
                "inner join seat on reservation.id_seat=seat.id_seat inner join room on room.id_room=seat.id_room where customer.id_customer=?";
        List<CustomerReservation> customer=new ArrayList<>();
        try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,idCustomer);

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                ConvertToList(customer,resultSet);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }

    public void ConvertToList(List<CustomerReservation> customers, ResultSet resultSet) throws Exception{
        customers.add(
                new CustomerReservation(
                        resultSet.getString("customer_first_name"),
                        resultSet.getString("customer_last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("reservation_date"),
                        resultSet.getInt("seat_number"),
                        resultSet.getString("room_name")
                )
        );
    }
}
