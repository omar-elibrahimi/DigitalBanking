package com.test.test.entities;

import java.util.List;
import java.util.Date;

import com.test.test.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "TYPE", length = 4, discriminatorType = DiscriminatorType.STRING)

@Data @NoArgsConstructor @AllArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private Date CreatedAt;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount")
    private List<Operations> operationList;
    private AccountStatus status;

}
