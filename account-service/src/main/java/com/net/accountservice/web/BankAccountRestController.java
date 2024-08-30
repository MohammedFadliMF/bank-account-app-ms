package com.net.accountservice.web;

import com.net.accountservice.clients.CustomerRestClient;
import com.net.accountservice.entities.BankAccount;
import com.net.accountservice.models.Customer;
import com.net.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepository bankAccountRepository,CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient=customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount accountList(@PathVariable String id){
        BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
