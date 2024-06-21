package com.test.test.controller;

import com.test.test.dto.CustomerDTO;
import com.test.test.entities.Customer;
import com.test.test.service.BanckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerController {
    private BanckService banckService;

    @GetMapping( "/products")
    public String products(){
        return "customers";
    }
    @GetMapping( "/customers")
    public List<Customer> listcustomer(){
        return banckService.listcustomer();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable(name = "id") Long id){
        return banckService.getCustomer(id);}

    @PostMapping("/customers")
    public void createCustomer(@RequestBody Customer customer){
        banckService.saveCustomer(customer);
    }

}
