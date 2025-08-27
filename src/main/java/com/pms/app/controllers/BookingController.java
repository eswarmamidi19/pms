package com.pms.app.controllers;

import com.pms.app.dtos.CreatingBookingDto;
import com.pms.app.models.Booking;
import com.pms.app.models.Customer;
import com.pms.app.services.BookingService;
import com.pms.app.services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    CustomerService customerService;
    @Autowired
    BookingService bookingService;


    //TODO: handler 1
    @GetMapping("/")
    public Customer allBookings(HttpServletRequest request) {
        return (Customer) request.getAttribute("loggedInUser");
    }

    // TODO : handler 2
    @GetMapping("/{id}")
    public List<Customer> getBookingById(HttpServletRequest request, @PathVariable int id) {

        return null;
    }

    @PostMapping("/customer")
    public ResponseEntity<Booking> creatingNewBooking(HttpServletRequest request, @RequestBody CreatingBookingDto creatingBookingDto) {
        Map<String, Object> loggedInCustomerMap = (Map<String, Object>) request.getAttribute("loggedInUser");
        Object userIdObj = loggedInCustomerMap.get("user_id");

        int userId;

        if (userIdObj instanceof Integer) {
            userId = (Integer) userIdObj;
        } else if (userIdObj instanceof String) {
            userId = Integer.parseInt((String) userIdObj);
        } else {
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }

        Optional<Customer> potentialCustomer = customerService.getCustomerById(userId);
        if (potentialCustomer.isEmpty()) {
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }

        Customer loggedInCustomer = potentialCustomer.get();

        return  ResponseEntity.ok(bookingService.addBooking(creatingBookingDto,loggedInCustomer));
    }


    // TODO : handler 3
    @PostMapping("/admin")
    public Booking creatingNewBookingAdmin(HttpServletRequest request, @RequestBody CreatingBookingDto creatingBookingDto) {
        Customer loggedInCustomer = (Customer) request.getAttribute("loggedInUser");
        System.out.println(creatingBookingDto);
        System.out.println(loggedInCustomer);
        return bookingService.addBooking(creatingBookingDto, loggedInCustomer);
    }

    // TODO : 4

    @PostMapping("/admin/update-status")
    public Booking updatingBookingStatusAdmin() {

        return null;
    }


}
