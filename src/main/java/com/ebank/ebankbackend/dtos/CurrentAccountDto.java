package com.ebank.ebankbackend.dtos;

import com.ebank.ebankbackend.Enums.AccountStatus;
import com.ebank.ebankbackend.entities.Operation;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class CurrentAccountDto {

    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private ClientDTO clientDTO;
    private double overDraft;



}
