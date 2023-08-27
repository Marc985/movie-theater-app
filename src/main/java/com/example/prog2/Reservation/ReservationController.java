package com.example.prog2.Reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ReservationController {
    private reservationService service;
    public ReservationController(reservationService service){
        this.service=service;
    }

    @GetMapping("/customersReservation")
    public List<CustomerReservation> filndAllCustomersReservation(){
        return service.AllCustomersReservation();
    }
    @GetMapping("/customersReservation/{idCustomer}")
    public List<CustomerReservation> findCustomerReservationById(@PathVariable int idCustomer){
        return service.ReservationByCustomerId(idCustomer);
    }
}
