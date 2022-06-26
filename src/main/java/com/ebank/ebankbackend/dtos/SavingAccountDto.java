package com.ebank.ebankbackend.dtos;

import com.ebank.ebankbackend.Enums.AccountStatus;
import com.ebank.ebankbackend.entities.Client;
import com.ebank.ebankbackend.entities.Operation;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
public class SavingAccountDto {

    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private ClientDTO clientDTO;
    private double interestRate;



}
