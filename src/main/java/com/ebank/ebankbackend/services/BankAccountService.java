package com.ebank.ebankbackend.services;

import com.ebank.ebankbackend.dtos.ClientDTO;
import com.ebank.ebankbackend.entities.Account;
import com.ebank.ebankbackend.entities.Client;

import java.util.List;

public interface BankAccountService {


    ClientDTO saveClient(ClientDTO client);

    Account saveCurrentAccount(double initialBalance, double overDraft, Long clientID);
    Account saveSavingAccount(double initialBalance,double interestRate, Long clientID);
    List<ClientDTO> CLIENT_LIST();
    Account getBankAccount(String accountId);
    void debit(String accountId,double amount);
    void credit(String accountId,double amount);
    void transfer(String debitedId,String creditedId,double amount);

    ClientDTO getClient(Long clientId) throws  RuntimeException;
}
