package com.pms.app.repositories;

import com.pms.app.models.Booking;
import com.pms.app.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
    public List<Booking> findByCustomer(Customer customer);
}
