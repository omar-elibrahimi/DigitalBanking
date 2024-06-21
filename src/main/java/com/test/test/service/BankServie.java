package com.test.test.service;


import com.test.test.entities.CurrentAccount;
import com.test.test.entities.Customer;
import com.test.test.entities.SavingAccount;
import com.test.test.enums.AccountStatus;
import com.test.test.repositry.BankAccountRepositry;
import com.test.test.repositry.CustomerRepositry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Transactional
public class BankServie {


    @Autowired
    private BankAccountRepositry bankAccountRepositry;
    private CustomerRepositry customerRepositry;

    public void consulter() {
        Stream.of("omar", "akram", "hamza ").forEach(name -> {
            Customer customer = new Customer();
            customer.setName(name);
            customerRepositry.save(customer);
        });
        customerRepositry.findAll().forEach(name2 -> {
            CurrentAccount currentAccount = new CurrentAccount();
            currentAccount.setId(UUID.randomUUID().toString());
            currentAccount.setBalance(Math.random()*9000);
            currentAccount.setOverDraft(9000.0);
            currentAccount.setStatus(AccountStatus.ACIVATED);
            currentAccount.setCreatedAt(new Date());
            currentAccount.setCustomer(name2);
            bankAccountRepositry.save(currentAccount);



            SavingAccount SavingAccount = new SavingAccount();
            SavingAccount.setId(UUID.randomUUID().toString());
            SavingAccount.setBalance(Math.random()*9000);
            SavingAccount.setInterest(9000.0);
            SavingAccount.setStatus(AccountStatus.ACIVATED);
            SavingAccount.setCreatedAt(new Date());
            SavingAccount.setCustomer(name2);
            bankAccountRepositry.save(SavingAccount);

        });

    }
}
