package com.ebank.ebankbackend.services;

import com.ebank.ebankbackend.entities.Account;
import com.ebank.ebankbackend.entities.Client;
import com.ebank.ebankbackend.repositories.AccountRepository;
import com.ebank.ebankbackend.repositories.ClientRepository;
import com.ebank.ebankbackend.repositories.OperationRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService{
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;
    Logger log=LoggerFactory.getLogger(this.getClass().getName());


    @Override
    public Client saveClient(Client client) {
        log.info("Saving Client");
        return null;
    }

    @Override
    public Account saveAccount(double initialBalance, String type, Long clientID) {
        return null;
    }

    @Override
    public List<Client> CLIENT_LIST() {
        return null;
    }

    @Override
    public Account getBankAccount(String accountId) {
        return null;
    }

    @Override
    public void debit(String accountId, double amount) {

    }

    @Override
    public void credit(String accountId, double amount) {

    }

    @Override
    public void transfer(Account debitedId, Account creditedId, double amount) {

    }
}
