package com.pms.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.app.dtos.CustomerDto;
import com.pms.app.dtos.CustomerLoginDto;
import com.pms.app.models.Customer;
import com.pms.app.services.CustomerService;

@RestController
@RequestMapping("/api/pms/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getAllCustomers() {

        return  customerService.getAllCustomers() ;
    }

    @PostMapping("/")

    public Customer createNewCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }


    //TODO : fix  this  eswar
    @PostMapping("/login")
    public  ResponseEntity loginCustomer(@RequestBody CustomerLoginDto customerLogin){
        Customer loggedInCustomer  =  customerService.getCustomerById(customerLogin.id);
        //TODO : dear future me please remember to add password field to customer model . hope you have a great day

        ResponseCookie cookie = ResponseCookie.from("loggedInUser" , loggedInCustomer.userId+"").build();

        return new ResponseEntity(HttpStatus.OK);
    }





}