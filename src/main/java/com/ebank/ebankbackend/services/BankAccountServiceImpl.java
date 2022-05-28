package com.ebank.ebankbackend.services;

import com.ebank.ebankbackend.Enums.AccountStatus;
import com.ebank.ebankbackend.entities.Account;
import com.ebank.ebankbackend.entities.Client;
import com.ebank.ebankbackend.entities.CurrentAccount;
import com.ebank.ebankbackend.entities.SavingAccount;
import com.ebank.ebankbackend.repositories.AccountRepository;
import com.ebank.ebankbackend.repositories.ClientRepository;
import com.ebank.ebankbackend.repositories.OperationRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;


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
        Client nclient= clientRepository.save(client);
        log.info("Saving Client");
        return nclient;
    }

    @Override
    public Account saveCurrentAccount(double initialBalance, double overDraft, Long clientID) {

        CurrentAccount account=new CurrentAccount();
        Client client=clientRepository.findById(clientID).orElse(null);
        if (client==null)
            throw new RuntimeException("Client not found");


        account.setId(UUID.randomUUID().toString());
        account.setBalance(Math.round(Math.random()*90000));
        account.setCreatedAt(new Date());
        account.setStatus(AccountStatus.Created);
        account.setClient(client);
        account.setOverDraft(overDraft);
        CurrentAccount savedCurrentAccount=accountRepository.save(account);

        return savedCurrentAccount;
    }

    @Override
    public Account saveSavingAccount(double initialBalance, double interestRate, Long clientID) {
        SavingAccount account=new SavingAccount();
        Client client=clientRepository.findById(clientID).orElse(null);
        if (client==null)
            throw new RuntimeException("Client not found");


        account.setId(UUID.randomUUID().toString());
        account.setBalance(Math.round(Math.random()*90000));
        account.setCreatedAt(new Date());
        account.setStatus(AccountStatus.Created);
        account.setClient(client);
        account.setInterestRate(interestRate);
        SavingAccount savedSavingAccount=accountRepository.save(account);

        return savedSavingAccount;
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
