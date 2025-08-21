package com.pms.app.models;

import java.util.ArrayList;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer userId;

    @Column(name="customer_name")
    @Nonnull
    public String customerName;

    @Column(name = "customer_email")
    @Nonnull
    public String customerEmail;

    @Column(name="mobile_number")
    @Nonnull
    public String customerMobileNumber;
    @Column(name="customer_address")
    @Nonnull
    public String customerAddress;

    public ArrayList<String> customerPreferences;

    @Column(name="role")
    @Nonnull
    public String role;
    public Customer() {}


    public Customer(String customerName, String customerEmail, String customerMobileNumber, String customerAddress,
                    ArrayList<String> customerPreferences, String role) {
        super();
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerMobileNumber = customerMobileNumber;
        this.customerAddress = customerAddress;
        this.customerPreferences = customerPreferences;
        this.role = role;
    }


    public Customer(Integer userId, String customerName, String customerEmail, String customerMobileNumber,
                    String customerAddress, ArrayList<String> customerPreferences, String role) {
        super();
        this.userId = userId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerMobileNumber = customerMobileNumber;
        this.customerAddress = customerAddress;
        this.customerPreferences = customerPreferences;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ArrayList<String> getCustomerPreferences() {
        return customerPreferences;
    }

    public void setCustomerPreferences(ArrayList<String> customerPreferences) {
        this.customerPreferences = customerPreferences;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




}
