package com.test.test.mapper;

import com.test.test.dto.CustomerDTO;
import com.test.test.entities.Customer;

public class mapper {

    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        // Customer customer1 = new Customer();
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setId(customer.getId());
        return customerDTO;
    }

    public Customer fromDTO(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }

    // za3ma tkun had qwada bhal haka
    // ahh ahh blan blan asadiqi ghadi nkun safe a salina o safe bhal amakin walo a sadiqi hfamitni yak a 3chiri

    // gharib hadchi shit pleaz matacha3lich garou bnt qahab walo a zbi fhaimitni yak shit a sadiqi fhamitni yak a 3chiri shit nit asadiqi
    // bchwiya malna achno kain asadiqi fhamitni yak a 3chiri malna tani asadiqi fhamitni





}


// daba hado kifach ghadi ikhdmo a sadqii hado homa les mtethod asadiqi yak ayeh o kifach tani had mn customer ldto ancreeiw wahd
