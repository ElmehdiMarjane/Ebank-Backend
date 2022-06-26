package com.ebank.ebankbackend.web;


import com.ebank.ebankbackend.dtos.ClientDTO;
import com.ebank.ebankbackend.entities.Client;
import com.ebank.ebankbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/Clients/{id}")
    public ClientDTO getClients(@PathVariable(name="id") Long clientId){

        return bankAccountService.getClient(clientId);
    }

    @PostMapping("/Clients")
    public ClientDTO saveCustomer(@RequestBody ClientDTO customerDTO){
        return bankAccountService.saveClient(customerDTO);
    }




}
