package com.ebank.ebankbackend;

import com.ebank.ebankbackend.Enums.AccountStatus;
import com.ebank.ebankbackend.Enums.operationType;
import com.ebank.ebankbackend.entities.*;
import com.ebank.ebankbackend.repositories.AccountRepository;
import com.ebank.ebankbackend.repositories.ClientRepository;
import com.ebank.ebankbackend.repositories.OperationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository, AccountRepository accountRepository, OperationRepository operationRepository){



        return args -> {
            Stream.of("IHAAB","abdelkader","Jilali").forEach(name->{
                Client client=new Client();
                client.setName(name);
                client.setEmail(name+"@gmail.com");
                clientRepository.save(client);
            });
            clientRepository.findAll().forEach(clt->{
                CurrentAccount current=new CurrentAccount();
                SavingAccount saving=new SavingAccount();

                current.setId(UUID.randomUUID().toString());
                current.setBalance(Math.round(Math.random()*90000));
                current.setCreatedAt(new Date());
                current.setStatus(AccountStatus.Created);
                current.setClient(clt);
                current.setOverDraft(9000);
                accountRepository.save(current);
                saving.setId(UUID.randomUUID().toString());
                saving.setBalance(Math.round(Math.random()*90000));
                saving.setCreatedAt(new Date());
                saving.setStatus(AccountStatus.Created);
                saving.setClient(clt);
                saving.setInterestRate(6.5);
                accountRepository.save(saving);


            });

            accountRepository.findAll().forEach(account -> {


                for(int i=0;i<5;i++){
                    Operation operation=new Operation();
                    operation.setOperationDate(new Date());
                    operation.setAmount(Math.round(Math.random()*10000));
                    operation.setType(Math.random()>0.5? operationType.DEBIT:operationType.CREDIT);
                    operation.setBankAccount(account);
                    operationRepository.save(operation);

                }


            });





        };



    }

}
