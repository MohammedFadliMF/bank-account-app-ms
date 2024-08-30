package com.net.customerservice.web;

import com.net.customerservice.entities.Customer;
import com.net.customerservice.reppository.CustomerRepositoy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    CustomerRepositoy customerRepositoy;

    public CustomerRestController(CustomerRepositoy customerRepositoy) {
        this.customerRepositoy = customerRepositoy;
    }
    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepositoy.findAll();
    }
    @GetMapping("/customers/{id}")
    public  Customer customerById(@PathVariable Long id){
        return customerRepositoy.findById(id).get();
    }
}
