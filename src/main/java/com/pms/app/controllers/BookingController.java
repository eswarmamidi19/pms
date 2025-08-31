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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
//@CrossOrigin(
//        originPatterns = {"http://localhost:4200", "http://127.0.0.1:4200"},
//        allowedHeaders = "*",
//        exposedHeaders = {"Authorization", "Content-Type"},
//        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
//        allowCredentials = "true",
//        maxAge = 3600
//)
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
    public ResponseEntity<List<Booking>> getBookingById(HttpServletRequest request, @PathVariable int id) {
        @SuppressWarnings("unchecked")
        Map<String, Object> loggedInCustomerMap = (Map<String, Object>) request.getAttribute("loggedInUser");
        Object userIdObj = loggedInCustomerMap.get("user_id");
        int userId;
        if (userIdObj instanceof Integer) {
            userId = (Integer) userIdObj;
        } else if (userIdObj instanceof String) {
            userId = Integer.parseInt((String) userIdObj);
        } else {
            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
        }
        Optional<Customer> potentialCustomer = customerService.getCustomerById(id);
        if (potentialCustomer.isEmpty()) {
            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
        }
        Customer loggedInCustomer = potentialCustomer.get();
        return ResponseEntity.ok(bookingService.getBookingByCustomerId(loggedInCustomer));
    }

    @PostMapping("/customer")
    public ResponseEntity<Booking> creatingNewBooking(HttpServletRequest request, @RequestBody CreatingBookingDto creatingBookingDto) {
       @SuppressWarnings("unchecked")
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
    @PostMapping("/admin/update-status/{id}")
    public ResponseEntity<Booking> updatingBookingStatusAdmin(HttpServletRequest request,@PathVariable int id , @RequestBody  Map<String , String> userStatus) {
        @SuppressWarnings("unchecked")
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
        if (!loggedInCustomer.role.equalsIgnoreCase("ADMIN")){
            return new ResponseEntity<Booking>(HttpStatus.FORBIDDEN);
        }
        // TODO :  update user
        Booking updatedBooking =  bookingService.updateBookingStatus(id, userStatus.get("user_id"));
        if (updatedBooking==null) {
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedBooking);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<Map<String , String>> getStatusByUser(HttpServletRequest request , @PathVariable int id){
        @SuppressWarnings("unchecked")
        Map<String, Object> loggedInCustomerMap = (Map<String, Object>) request.getAttribute("loggedInUser");
        Object userIdObj = loggedInCustomerMap.get("user_id");
        int userId;
        if (userIdObj instanceof Integer) {
            userId = (Integer) userIdObj;
        } else if (userIdObj instanceof String) {
            userId = Integer.parseInt((String) userIdObj);
        } else {
            return new ResponseEntity<Map<String , String>>(HttpStatus.NOT_FOUND);
        }
        Optional<Customer> potentialCustomer = customerService.getCustomerById(userId);
        if (potentialCustomer.isEmpty()) {
            return new ResponseEntity<Map<String , String>>(HttpStatus.NOT_FOUND);
        }
        Customer loggedInCustomer = potentialCustomer.get();

        Booking requiredBooking = bookingService.getBookingById(id);

        if (requiredBooking==null){
             return new ResponseEntity<Map<String , String>>(HttpStatus.NOT_FOUND);
        }
        Map<String , String> responseMap = new HashMap<String,String>();

        responseMap.put("status" , requiredBooking.bookingStatus);

        return ResponseEntity.ok(responseMap);
    }


    @GetMapping("/user_bookings")
    public ResponseEntity<List<Booking>> getAllBookingsByLoggedInUser(HttpServletRequest request){
        @SuppressWarnings("unchecked")
        Map<String, Object> loggedInCustomerMap = (Map<String, Object>) request.getAttribute("loggedInUser");
        Object userIdObj = loggedInCustomerMap.get("user_id");
        int userId;
        if (userIdObj instanceof Integer) {
            userId = (Integer) userIdObj;
        } else if (userIdObj instanceof String) {
            userId = Integer.parseInt((String) userIdObj);
        } else {
            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
        }
        Optional<Customer> potentialCustomer = customerService.getCustomerById(userId);
        if (potentialCustomer.isEmpty()) {
            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
        }
        Customer loggedInCustomer = potentialCustomer.get();

        return ResponseEntity.ok(bookingService.getBookingByCustomerId(loggedInCustomer));
    }
}

