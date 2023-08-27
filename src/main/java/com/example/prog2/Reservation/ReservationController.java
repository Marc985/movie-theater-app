package com.example.prog2.Reservation;

import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/reservation")
    public String addNewReservation(@RequestBody Reservation reservation){
        service.newReservation(reservation.getReservationDate(),reservation.getIdSeat(), reservation.getIdCustomer());
        return "reservation added succefully";
    }
}
