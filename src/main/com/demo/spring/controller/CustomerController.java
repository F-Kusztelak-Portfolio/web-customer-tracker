package main.com.demo.spring.controller;

import main.com.demo.spring.entity.Customer;
import main.com.demo.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String listCustomers(Model theModel) {
        // get customers from service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        // save the customer using service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {
        // get the customer from service
        Customer theCustomer = customerService.getCustomer(theId);

        // set customer as model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        // send over to form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        // delete the customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

}
