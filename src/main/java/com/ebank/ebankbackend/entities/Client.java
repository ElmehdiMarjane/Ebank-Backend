package com.ebank.ebankbackend.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;




@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "client")
    private List<Account> bankAccounts;

}
