package com.pms.app.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

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

    public String customerPreferences;

    @Column(name="role")
    @Nonnull
    public String role;

    @Column(name="country_code")
    @Nonnull
    public String countryCode;

    @Column(name="password")
    @Nonnull
    public String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore

    public List<Booking> bookingList = new ArrayList<>();
    public Customer() {}


    public Customer(String customerName, String customerEmail, String customerMobileNumber, String customerAddress,
                    String customerPreferences, String role , String countryCode , String password) {
        super();
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerMobileNumber = customerMobileNumber;
        this.customerAddress = customerAddress;
        this.customerPreferences = customerPreferences;
        this.role = role;
        this.countryCode=countryCode;
        this.password = password;
    }


    public Customer(Integer userId, String customerName, String customerEmail, String customerMobileNumber,
                    String customerAddress, String customerPreferences, String role , String countryCode) {
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

    public String getCustomerPreferences() {
        return customerPreferences;
    }

    public void setCustomerPreferences(String customerPreferences) {
        this.customerPreferences = customerPreferences;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCountryCode(){
         return this.countryCode;
    }

    public void setCountryCode(String countryCode){
         this.countryCode = countryCode;
    }

    public List<Booking> getBookings() {
        return bookingList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + userId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerMobileNumber='" + customerMobileNumber + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerPreferences='" + customerPreferences + '\'' +
                ", role='" + role + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
