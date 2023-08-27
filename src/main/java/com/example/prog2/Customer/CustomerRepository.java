package com.example.prog2.Customer;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements  CustomerInterfaceRepository{
    Connection connection;
    public CustomerRepository(Connection connection){
        this.connection=connection;
    }
    @Override
    public List<Customer> getCustomerById(int idCustomer){
    String sql="select * from customer where id_customer="+idCustomer;
    List<Customer> allCustomer=new ArrayList<>();
    try(PreparedStatement statement=connection.prepareStatement(sql)) {
        ResultSet result=statement.executeQuery();
        while (result.next()){
            ConvertToList(allCustomer,result);
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
        return allCustomer;
    }

    @Override
    public List<Customer> getAllCustomer() {
String sql="select * from customer";
List<Customer> allCustomer=new ArrayList<>();
try (PreparedStatement statement=connection.prepareStatement(sql)){
    ResultSet resultSet=statement.executeQuery();
    while (resultSet.next()){
        ConvertToList(allCustomer,resultSet);
    }

}
catch (Exception e){
    e.printStackTrace();
}
        return allCustomer ;
    }




    @Override
    public void insertCustomer(String firstName, String lastName, String email) throws Exception{
String insert="insert into customer (customer_first_name, customer_last_name, email) values (?,?,?)";
try (PreparedStatement statement=connection.prepareStatement(insert)){
   statement.setString(1,firstName);
   statement.setString(2,lastName);
   statement.setString(3,email);
   statement.executeUpdate();
}

    }



    @Override
    public void updateCustomer(int idCustomer, String firstName, String lastName) {
        String sql="update customer set customer_first_name=?,customer_last_name=? where id_customer=?";

        try(PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setInt(3,idCustomer);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void ConvertToList(List<Customer> customers,ResultSet resultSet) throws Exception{
        customers.add(
                new Customer(
                        resultSet.getInt("id_customer"),
                        resultSet.getString("customer_first_name"),
                        resultSet.getString("customer_last_name"),
                        resultSet.getString("email")
                )
        );
    }
}
