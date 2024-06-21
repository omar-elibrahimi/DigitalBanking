package com.test.test;

import com.test.test.entities.BankAccount;
import com.test.test.entities.CurrentAccount;
import com.test.test.entities.Customer;
import com.test.test.entities.SavingAccount;
import com.test.test.enums.AccountStatus;
import com.test.test.repositry.BankAccountRepositry;
import com.test.test.repositry.CustomerRepositry;
import com.test.test.service.BanckService;
import com.test.test.service.BankServie;
import com.test.test.service.bankserviceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}


	//@Bean
	CommandLineRunner start(BanckService banckService) {
		return args -> {
			Stream.of("akram2", "hamza2", "omar2").forEach(name->{
				Customer customer = new Customer();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");
				banckService.saveCustomer(customer);
			});
			banckService.listcustomer().forEach(customer -> {
				try {
					banckService.createBankAccount(Math.random()*9000, customer.getId());
					List<BankAccount> accounts = banckService.Listbankccount();
					for ( BankAccount account:accounts) {
						for(int i = 0 ; i<10 ; i++){
							banckService.debit(100, account.getId(), "debit");
							banckService.credit(200, account.getId(), "cedit");
						}

					}

				} catch(RuntimeException e){
					e.printStackTrace();
				}
			});
		};
	}
}




