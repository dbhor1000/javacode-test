package com.javacode.javacode_test.repository;

import com.javacode.javacode_test.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount getReferenceByWalletId(UUID walletId);
    BankAccount getReferenceById(long id);

}
