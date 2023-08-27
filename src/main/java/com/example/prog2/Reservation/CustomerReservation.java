package com.example.prog2.Reservation;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerReservation {
   private String firstName;
   private String lastName;
   private String email;
   private String reservationDate;
   private int seatNumber;
   private String roomName;
}
