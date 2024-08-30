package com.net.accountservice.clients;

import com.net.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name="customerService",fallbackMethod = "getAllCustomers")
    List <Customer> allCustomers();
    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstName("Not Valid");
        customer.setLastName("Not Valid");
        customer.setEmail("Not Valid");
        return customer;
    }
    default  List<Customer> getAllCustomers(Exception exception){
        return List.of();
    }
}
