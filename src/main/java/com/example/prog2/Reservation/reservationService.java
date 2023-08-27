package com.example.prog2.Reservation;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reservationService {
    private  ReservationRepository repository;
    public reservationService(ReservationRepository repository){
        this.repository=repository;
    }
    public List<CustomerReservation> AllCustomersReservation(){
        return repository.getAllCustomersReservation();
    }
    public  List<CustomerReservation> ReservationByCustomerId(int idCustomer){
        return repository.getReservationByIdCustomer(idCustomer);
    }
}
