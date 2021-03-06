package com.ebank.ebankbackend.services;

import com.ebank.ebankbackend.Enums.AccountStatus;
import com.ebank.ebankbackend.Enums.operationType;
import com.ebank.ebankbackend.dtos.AccountDto;
import com.ebank.ebankbackend.dtos.ClientDTO;
import com.ebank.ebankbackend.dtos.CurrentAccountDto;
import com.ebank.ebankbackend.dtos.SavingAccountDto;
import com.ebank.ebankbackend.entities.*;
import com.ebank.ebankbackend.mappers.BankAccountMapperImpl;
import com.ebank.ebankbackend.repositories.AccountRepository;
import com.ebank.ebankbackend.repositories.ClientRepository;
import com.ebank.ebankbackend.repositories.OperationRepository;
import lombok.AllArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService{
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;
    private BankAccountMapperImpl dtoMapper;



    @Override
    public ClientDTO saveClient(ClientDTO client) {
        Client nclient= dtoMapper.fromClientDTO(client);
        Client savedClient= clientRepository.save(nclient);
        log.info("Saving Client");
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public CurrentAccountDto saveCurrentAccount(double initialBalance, double overDraft, Long clientID) {

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

        return dtoMapper.fromCurrentAccount(savedCurrentAccount);
    }

    @Override
    public SavingAccountDto saveSavingAccount(double initialBalance, double interestRate, Long clientID) {
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

        return dtoMapper.fromSavingAccount(savedSavingAccount) ;
    }


    @Override
    public List<ClientDTO> CLIENT_LIST() {
        List <Client> clients=clientRepository.findAll();
        return clients.stream().map(clt->dtoMapper.fromClient(clt)).collect(Collectors.toList());

    }

    @Override
    public AccountDto getBankAccount(String accountId) {

        Account account=accountRepository.findById(accountId).orElse(null);
        if(account==null)
            throw new RuntimeException("Account not found");
        if(account instanceof SavingAccount){

            return dtoMapper.fromSavingAccount((SavingAccount) account);
        }
        else{
            return dtoMapper.fromCurrentAccount((CurrentAccount) account);
        }
    }

    @Override
    public void debit(String accountId, double amount) {


        Account debitedAccount=accountRepository.findById(accountId).orElse(null);
        if(debitedAccount==null)
            throw new RuntimeException("Account not found");
        if(debitedAccount.getBalance()<amount)
            throw new RuntimeException("InSufficient Balance");
        Operation operation=new Operation();
        operation.setType(operationType.DEBIT);
        operation.setAmount(amount);
        operation.setOperationDate(new Date());
        operation.setBankAccount(debitedAccount);
        operationRepository.save(operation);
        debitedAccount.setBalance(debitedAccount.getBalance()-amount);
        accountRepository.save(debitedAccount);

    }

    @Override
    public List<AccountDto> ACCOUNT_LIST() {
        List<Account> accountList=accountRepository.findAll();

        List<AccountDto> accountDtoList;
        accountDtoList= accountList.stream().map(acc->{

            if(acc instanceof SavingAccount){

                return dtoMapper.fromSavingAccount((SavingAccount) acc);
            }
            else{
                return dtoMapper.fromCurrentAccount((CurrentAccount) acc);
            }
        }).collect(Collectors.toList());
        return accountDtoList;
    }

    @Override
    public void credit(String accountId, double amount) {
        Account creditedAccount=accountRepository.findById(accountId).orElse(null);
        if(creditedAccount==null)
            throw new RuntimeException("Account not found");

        Operation operation=new Operation();
        operation.setType(operationType.CREDIT);
        operation.setAmount(amount);
        operation.setOperationDate(new Date());
        operation.setBankAccount(creditedAccount);
        operationRepository.save(operation);
        creditedAccount.setBalance(creditedAccount.getBalance()+amount);
        accountRepository.save(creditedAccount);
    }

    @Override
    public void transfer(String debitedId, String creditedId, double amount) {
        debit(debitedId,amount);
        credit(debitedId,amount);

    }
    @Override
    public ClientDTO getClient(Long clientId) throws  RuntimeException{
        Client client= clientRepository.findById(clientId)
                .orElseThrow(()->new RuntimeException("Not found"));
        return dtoMapper.fromClient(client);
    }

    @Override
    public ClientDTO updateClient(ClientDTO client) {
        Client nclient= dtoMapper.fromClientDTO(client);
        Client savedClient= clientRepository.save(nclient);
        log.info("updating Client");
        return dtoMapper.fromClient(savedClient);
    }
    @Override
    public void deleteClient(Long clientId) {

        clientRepository.deleteById(clientId);
    }


}
