package com.pms.app.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pms.app.utils.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.app.dtos.CustomerDto;
import com.pms.app.models.Customer;
import com.pms.app.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    JsonParser<Customer> objectJsontoString;

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return  customerService.getAllCustomers() ;
    }

    @PostMapping("/auth/register")

    public Customer createNewCustomer(@RequestBody CustomerDto customerDto) {
        System.out.println(customerDto);
        return customerService.addCustomer(customerDto);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<Customer> login (@RequestBody Map<String , String> loginRequestBody){
        // TODO : handle login

        Optional<Customer> potentialCustomer = customerService.getCustomerById(Integer.parseInt(loginRequestBody.get("user_id")));
        if (potentialCustomer.isEmpty()){
              return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        Customer requiredCustomer = potentialCustomer.get();
        if(requiredCustomer.password.equals(loginRequestBody.get("password")+"")){
            String customerJson = "";
            try{
                 customerJson = objectJsontoString.convertToJsonString(requiredCustomer);
            }catch(JsonProcessingException ex){
                System.out.println("Error while Parsing json");
            }


            HttpHeaders headers = new HttpHeaders();

            headers.add("Authorization" , "Bearer" + "##" + customerJson);

            return new ResponseEntity<Customer>(requiredCustomer , headers , HttpStatus.OK);
        }



        return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
    }


}