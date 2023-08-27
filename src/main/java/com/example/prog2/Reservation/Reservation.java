package com.example.prog2.Reservation;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Reservation {
    private String reservationDate;
    private int idSeat;
    private  int idCustomer;
}
