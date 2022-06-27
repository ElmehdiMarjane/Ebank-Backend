package com.ebank.ebankbackend.web;


import com.ebank.ebankbackend.dtos.AccountDto;
import com.ebank.ebankbackend.dtos.ClientDTO;
import com.ebank.ebankbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {

    BankAccountService bankAccountService;

    @GetMapping("/Accounts")
    public List<AccountDto> clients(){

        return bankAccountService.ACCOUNT_LIST();
    }

    @GetMapping("/Accounts/{id}")
    public AccountDto getClients(@PathVariable(name="id") String accountId){

        return bankAccountService.getBankAccount(accountId);
    }



}
