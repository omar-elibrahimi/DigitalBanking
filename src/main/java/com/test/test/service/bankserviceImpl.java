package com.test.test.service;

import com.test.test.dto.CustomerDTO;
import com.test.test.entities.*;
import com.test.test.enums.OperationType;
import com.test.test.repositry.BankAccountRepositry;
import com.test.test.repositry.OperationRepo;
import jdk.dynalink.Operation;
import com.test.test.repositry.CustomerRepositry;
//import com.test.test.mapper.mapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class bankserviceImpl implements BanckService {


    BankAccountRepositry accountRepositry;
    CustomerRepositry customerRepositry;
    OperationRepo operationRepo;
   // mapper mapper;



    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("save customer");
        Customer cust = new Customer();
        cust = customerRepositry.save(customer);
        return cust;
    }

    @Override
    public BankAccount createBankAccount(double balance, Long customer_id) throws RuntimeException {
        // find customer by id
        Customer customer = customerRepositry.findById(customer_id).orElse(null);

        if (customer == null) throw new RuntimeException("no customer with this id");
        // create instance of entity
        CurrentAccount currentAccount = new CurrentAccount();
        // set balance
        currentAccount.setId(UUID.randomUUID().toString());
        currentAccount.setBalance(balance);
        currentAccount.setCustomer(customer);

        CurrentAccount savedaccount = new CurrentAccount();
        savedaccount = accountRepositry.save(currentAccount);


        return savedaccount;
    }

    @Override
    public BankAccount getBankAccount(String accountID) {
        BankAccount bankAccount = new BankAccount();
        bankAccount = accountRepositry.findById(accountID).orElseThrow(()-> new RuntimeException("bank account not found"));
        return bankAccount;
    }

    @Override
    public List<Customer> listcustomer() {
        List<Customer> customers = new ArrayList<>();
        customers = customerRepositry.findAll();
        System.out.print(customers);
        return customers;
    }

    // kifach
    //daba kifach andiro hadchi fhamitn
    // daba bghirna for each custoemrs ndiro lih hadik funciot
    @Override
    public void debit(double amount, String account_ID, String Description) {
        BankAccount bankAccount = getBankAccount(account_ID);
        if (bankAccount.getBalance()<amount)
            throw new RuntimeException("balance non suffisent");
        Operations operations = new Operations();
        operations.setType(OperationType.DRAW);
        operations.setAmount(amount);
        operations.setBankAccount(bankAccount);
        Operations savedOperation = operationRepo.save(operations);
        bankAccount.setBalance(bankAccount.getBalance()-amount);

    }

    @Override
    public void credit(double amount, String account_ID ,String Description) {
        BankAccount bankAccount = getBankAccount(account_ID);
        Operations operations = new Operations();
        operations.setBankAccount(bankAccount);
        operations.setType(OperationType.DRAFT);
        operations.setAmount(amount);
        Operations operationssaved = operationRepo.save(operations);
        bankAccount.setBalance(bankAccount.getBalance()+amount);
    }

    @Override
    public void virement(String accountSource, String accountDestin, double amount) {


        debit(amount, accountSource, "transfer to "+ accountDestin);
        credit(amount, accountDestin, "tansfer from"+ accountSource);


    }

    @Override
    public List<BankAccount> Listbankccount() {
        return accountRepositry.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer customer = customerRepositry.findById(id).orElse(null);
        return customer;
    }

    //


}
