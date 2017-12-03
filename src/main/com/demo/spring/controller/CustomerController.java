package main.com.demo.spring.controller;

import main.com.demo.spring.dao.CustomerDAO;
import main.com.demo.spring.entity.Customer;
import main.com.demo.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Copyright 2017 by Filip Kusztelak
 * Created by f.kusztelak@gmail.com on 2017-12-02.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public String listCustomers(Model theModel){

        // get customers from service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
