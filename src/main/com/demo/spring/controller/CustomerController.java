package main.com.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright 2017 by Filip Kusztelak
 * Created by f.kusztelak@gmail.com on 2017-12-02.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("list")
    public String listCustomers(Model theModel){

        return "list-customers";
    }
}
