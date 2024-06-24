package com.javacode.javacode_test.repository;

import com.javacode.javacode_test.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount getReferenceByWalletId(UUID walletId);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(nativeQuery = true,
            value = """
    update bank_account
    set account_balance = (account_balance + :amount)
    where wallet_id = :uuid;
    """
    )
    void updateBalance(UUID uuid, Double amount);

}
