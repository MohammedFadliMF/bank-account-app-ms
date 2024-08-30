package com.net.customerservice.reppository;

import com.net.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoy extends JpaRepository<Customer,Long> {

}
