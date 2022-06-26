package com.ebank.ebankbackend.web;


import com.ebank.ebankbackend.dtos.ClientDTO;
import com.ebank.ebankbackend.entities.Client;
import com.ebank.ebankbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController

public class ClientRestController {
    BankAccountService bankAccountService;

    @GetMapping("/Clients")
    public List<ClientDTO> clients(){

        return bankAccountService.CLIENT_LIST();
    }



}
