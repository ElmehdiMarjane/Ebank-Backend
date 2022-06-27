package com.ebank.ebankbackend.services;

import com.ebank.ebankbackend.dtos.AccountDto;
import com.ebank.ebankbackend.dtos.ClientDTO;
import com.ebank.ebankbackend.dtos.CurrentAccountDto;
import com.ebank.ebankbackend.dtos.SavingAccountDto;
import com.ebank.ebankbackend.entities.Account;
import com.ebank.ebankbackend.entities.Client;

import java.util.List;

public interface BankAccountService {


    ClientDTO saveClient(ClientDTO client);

    CurrentAccountDto saveCurrentAccount(double initialBalance, double overDraft, Long clientID);
    SavingAccountDto saveSavingAccount(double initialBalance, double interestRate, Long clientID);
    List<ClientDTO> CLIENT_LIST();
    List<AccountDto> ACCOUNT_LIST();
    AccountDto getBankAccount(String accountId);
    void debit(String accountId,double amount);
    void credit(String accountId,double amount);

    void transfer(String debitedId,String creditedId,double amount);

    ClientDTO getClient(Long clientId) throws  RuntimeException;

    ClientDTO updateClient(ClientDTO client);

    void deleteClient(Long clientId);
}
