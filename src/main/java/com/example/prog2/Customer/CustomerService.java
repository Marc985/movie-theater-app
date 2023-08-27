package com.example.prog2.Customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository repository;
    public CustomerService(CustomerRepository repository){
        this.repository=repository;
    }
    public List<Customer> getById(int idCustomer){
        return repository.getCustomerById(idCustomer);
    }
    public List<Customer> getAll(){
        return repository.getAllCustomer();
    }

    public void addNewCustomer(String firstName,String lastName,String email) throws Exception{
        if(firstName==null||firstName.trim().isEmpty())
            throw  new IllegalArgumentException("first name can't be null");
        if(lastName==null||lastName.trim().isEmpty())
            throw new IllegalArgumentException("last name can't be null");
        if(email==null||email.trim().isEmpty())
            throw new IllegalArgumentException("email can't be null");
        if(!email.contains("@"))
            throw new IllegalArgumentException("email address must contain \"@\"");
        repository.insertCustomer(firstName,lastName,email);


    }
    public void updateCustomer(int idCustomer,String firstName,String lastName){
        List<Customer> ExistingCustomer=getById(idCustomer);
        if(ExistingCustomer.size()==0){
            throw  new IllegalArgumentException("customer with id"+idCustomer+" not found");
        }
        if(firstName==null || firstName.isEmpty()){
            firstName=ExistingCustomer.get(0).getCustomerName();
        }
        if(lastName==null || lastName.isEmpty()){
            lastName=ExistingCustomer.get(0).getCustomerLastName();
        }
        if(lastName==null && firstName==null)
            throw new IllegalArgumentException("this must contain something to update");
        repository.updateCustomer(idCustomer,firstName,lastName);

    }
}
