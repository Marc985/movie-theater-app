package com.example.prog2.Customer;

import java.util.List;

public interface CustomerInterfaceRepository {
    public List<Customer> getCustomerById(int idCustomer);
    public List<Customer> getAllCustomer();

    void insertCustomer(String firstName, String lastName, String email) throws Exception;

    public void updateCustomer();
}
