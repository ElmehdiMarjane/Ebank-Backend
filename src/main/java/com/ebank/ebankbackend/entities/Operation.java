package com.ebank.ebankbackend.entities;

import java.util.Date;

import com.ebank.ebankbackend.Enums.operationType;
import lombok.*;

import javax.persistence.*;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Operation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;
    @Enumerated(EnumType.STRING)
    private operationType type;
    @ManyToOne
    private Account bankAccount;






}
