
package com.pms.app.dtos;

public class CustomerDto {
    public String customer_name;
    public String email;
    public String mobile_number;
    public String address;
    public String password;
    public String confirmPassword;


    public CustomerDto() {}


    public CustomerDto(String customer_name, String email, String mobile_number, String address, String password,
                       String confirmPassword) {
        super();
        this.customer_name = customer_name;
        this.email = email;
        this.mobile_number = mobile_number;
        this.address = address;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }


    public String getCustomer_name() {
        return customer_name;
    }


    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getMobile_number() {
        return mobile_number;
    }


    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }


    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    @Override
    public String toString() {
        return "CustomerDto [customer_name=" + customer_name + ", email=" + email + ", mobile_number=" + mobile_number
                + ", address=" + address + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
    }



}