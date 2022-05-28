package com.ebank.ebankbackend.repositories;

import com.ebank.ebankbackend.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long> {
}
