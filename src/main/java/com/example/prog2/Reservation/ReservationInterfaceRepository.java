package com.example.prog2.Reservation;

import java.util.List;

public interface ReservationInterfaceRepository {
    public List<CustomerReservation> getAllCustomersReservation();
    public List<CustomerReservation> getReservationByIdCustomer(int idCustomer);
    public  void addNewReservation(String reservationDate,int idSeat,int idCustomer);
}
