package com.pms.app.controllers;

import com.pms.app.dtos.CreatingBookingDto;
import com.pms.app.models.Booking;
import com.pms.app.models.Customer;
import com.pms.app.services.BookingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {


    @Autowired
    BookingService bookingService;

    public Customer allBookings(HttpServletRequest request){
        return  (Customer) request.getAttribute("loggedInUser");
    }

    @GetMapping("/test")
    public Booking creatingNewBooking( HttpServletRequest request ,  @RequestBody CreatingBookingDto creatingBookingDto){
        Customer loggedInCustomer = (Customer) request.getAttribute("loggedInUser");
        System.out.println(creatingBookingDto);
        System.out.println(loggedInCustomer);
        return bookingService.addBooking(creatingBookingDto , loggedInCustomer);
    }

}
