package com.example.prog2.Reservation;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerReservation {
    String firstName;
    String lastName;
    String email;
    String reservationDate;
    int seatNumber;
    String roomName;
}
