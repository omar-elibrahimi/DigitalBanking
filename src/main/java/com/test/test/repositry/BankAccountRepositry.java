package com.test.test.repositry;

import com.test.test.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepositry extends JpaRepository<BankAccount, String> {
}
