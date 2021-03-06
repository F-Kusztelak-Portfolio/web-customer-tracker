package main.com.demo.spring.dao;

import main.com.demo.spring.entity.Customer;

import java.util.List;

/**
 * Created by f.kusztelak@gmail.com on 2017-12-02.
 */
public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}


