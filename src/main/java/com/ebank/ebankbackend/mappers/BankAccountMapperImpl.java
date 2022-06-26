package com.ebank.ebankbackend.mappers;

import com.ebank.ebankbackend.dtos.ClientDTO;
import com.ebank.ebankbackend.dtos.CurrentAccountDto;
import com.ebank.ebankbackend.dtos.SavingAccountDto;
import com.ebank.ebankbackend.entities.Client;
import com.ebank.ebankbackend.entities.CurrentAccount;
import com.ebank.ebankbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {

    public ClientDTO fromClient(Client client){
        ClientDTO clientDTO=new ClientDTO();
        BeanUtils.copyProperties(client,clientDTO);

        return clientDTO;
    }
    public Client fromClientDTO(ClientDTO clientDTO){
        Client client=new Client();
        BeanUtils.copyProperties(clientDTO,client);
        return client;
    }

    public SavingAccountDto fromSavingAccount(SavingAccount savingAccount){
        SavingAccountDto SavingDTO=new SavingAccountDto();
        BeanUtils.copyProperties(savingAccount,SavingDTO);
        SavingDTO.setClientDTO(fromClient(savingAccount.getClient()));
        return SavingDTO;

    }
    public SavingAccount fromSavingAccountDto(SavingAccountDto savingAccountDto){
        SavingAccount saving=new SavingAccount();
        BeanUtils.copyProperties(savingAccountDto,saving);
        saving.setClient(fromClientDTO(savingAccountDto.getClientDTO()));
        return saving;

    }
    public CurrentAccountDto fromCurrentAccount(CurrentAccount currentAccount){
        CurrentAccountDto CurrentDTO=new CurrentAccountDto();
        BeanUtils.copyProperties(currentAccount,CurrentDTO);
        CurrentDTO.setClientDTO(fromClient(currentAccount.getClient()));

        return CurrentDTO;

    }

    public CurrentAccount fromCurrentAccountDto(CurrentAccountDto currentAccountDto){
        CurrentAccount current=new CurrentAccount();
        BeanUtils.copyProperties(currentAccountDto,current);
        current.setClient(fromClientDTO(currentAccountDto.getClientDTO()));
        return current;

    }


}
