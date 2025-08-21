

package com.pms.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.app.models.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}

