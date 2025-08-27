package com.pms.app.services;

import com.pms.app.dtos.CreatingBookingDto;
import com.pms.app.models.Booking;
import com.pms.app.models.Customer;
import com.pms.app.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BookingService {
    @Autowired
    BookingRepo bookingRepo;

    public Booking createBooking(Booking booking){
        return bookingRepo.save(booking);
    }

    public List<Booking> allBooking(){
       return bookingRepo.findAll();
    }


    public List<Booking> getBookingByCustomerId(Customer customer){
           return  bookingRepo.findByCustomer(customer);
    }

    public Booking addBooking(CreatingBookingDto creatingBookingDto , Customer loggedCustomer){
         Booking newBooking = new Booking(loggedCustomer.customerName , loggedCustomer.customerAddress , loggedCustomer.customerMobileNumber , creatingBookingDto.receiver_name , creatingBookingDto.receiverAddress , creatingBookingDto.receiver_pin , creatingBookingDto.receiver_phone_number,creatingBookingDto.parcel_weight_grams, creatingBookingDto.parcel_content_desc, creatingBookingDto.parcel_delivery_type , creatingBookingDto.parcel_packing_preference , creatingBookingDto.parcel_pickup_time , creatingBookingDto.parcel_drop_time , creatingBookingDto.serviceCost, LocalDateTime.now()  ,loggedCustomer , "BOOKED" );
         return this.createBooking(newBooking);
    }


}
