
package com.pms.app.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.app.dtos.CustomerDto;
import com.pms.app.models.Customer;
import com.pms.app.repositories.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    public Customer addCustomer(CustomerDto customerDto) {
        Customer cust = customerDtoToCustomer(customerDto);
        return customerRepo.save(cust);
    }

    public Customer customerDtoToCustomer(CustomerDto customerDto) {

        return new Customer(customerDto.customer_name , customerDto.email   , customerDto.mobile_number , customerDto.address, new ArrayList<String>(Arrays.asList("mail")), "customer");
    }


    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepo.getReferenceById(id);
    }
}
