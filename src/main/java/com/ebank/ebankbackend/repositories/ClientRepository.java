package com.ebank.ebankbackend.repositories;

import com.ebank.ebankbackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
