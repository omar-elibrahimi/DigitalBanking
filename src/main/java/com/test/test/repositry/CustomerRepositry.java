package com.test.test.repositry;

import com.test.test.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositry extends JpaRepository<Customer, Long> {
}
