package com.example.prog2.Customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CustomerController {
    private CustomerService service;
    public CustomerController(CustomerService service){
        this.service=service;
    }
    @GetMapping("/customers/{idCustomer}")
    public List<Customer> GetCustomerById(@PathVariable int idCustomer){
        return service.getById(idCustomer);
    }
    @GetMapping("/customers")
    public  List<Customer> allCustomer(){
        return service.getAll();
    }
    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        try{
            service.addNewCustomer(customer.getCustomerName(),customer.getCustomerLastName(), customer.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body("new customer inserted succefully");
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.CREATED).body("request error:"+e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("there is an error on the server");
        }
    }
}
