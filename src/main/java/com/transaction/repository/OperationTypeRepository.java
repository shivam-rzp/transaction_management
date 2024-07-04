package com.transaction.repository;

import com.transaction.entity.Account;
import com.transaction.entity.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {
}
