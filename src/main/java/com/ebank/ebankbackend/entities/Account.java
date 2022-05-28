package com.ebank.ebankbackend.entities;

import com.ebank.ebankbackend.Enums.AccountStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Account {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "bankAccount")
    private List<Operation> accountOperations;



}
