package main.com.demo.spring.dao;

import main.com.demo.spring.entity.Customer;

import java.util.List;

/**
 * Copyright 2017 by Filip Kusztelak
 * Created by f.kusztelak@gmail.com on 2017-12-02.
 */
public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}


