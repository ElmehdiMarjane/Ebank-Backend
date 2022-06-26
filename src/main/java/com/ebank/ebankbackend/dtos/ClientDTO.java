package com.ebank.ebankbackend.dtos;

import com.ebank.ebankbackend.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;



@Data
public class ClientDTO {

    private Long id;
    private String name;
    private String email;

}
