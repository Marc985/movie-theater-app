package com.example.prog2.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {

   private int idCustomer;
   private String customerName;
   private String customerLastName;
   private String Email;
}
