package com.ebank.ebankbackend.repositories;

import com.ebank.ebankbackend.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
