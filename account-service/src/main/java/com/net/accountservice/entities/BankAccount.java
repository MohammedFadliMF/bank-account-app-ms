package com.net.accountservice.entities;

import com.net.accountservice.enums.AccountType;
import com.net.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private  double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
