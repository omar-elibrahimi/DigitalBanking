package com.test.test.service;

import com.test.test.dto.CustomerDTO;
import com.test.test.entities.BankAccount;
import com.test.test.entities.Customer;

import java.util.List;

public interface BanckService {

    Customer saveCustomer(Customer customer);
    BankAccount createBankAccount(double balance, Long customer_id);
    BankAccount getBankAccount(String accountID);
    List<Customer> listcustomer();
    void debit(double amount, String account_ID, String Description);
    void credit(double amount, String account_ID, String Description);
    void virement(String accountSource, String accountDestin, double amount);
    List<BankAccount> Listbankccount();
    Customer getCustomer(Long id);
}


// fin kain had w9 dyal lmockil a zbi fhamitni yak a a3chiri fin kain had zbi hfamitni yak dyal lmochkil gharib hadchi
// fin kain had zbi dena kolchi howa hadk bdelan f