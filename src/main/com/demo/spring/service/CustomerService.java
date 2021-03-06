package main.com.demo.spring.service;

import main.com.demo.spring.entity.Customer;

import java.util.List;

/**
 * Created by f.kusztelak@gmail.com on 2017-12-03.
 */
public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
