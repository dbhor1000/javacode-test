package com.javacode.javacode_test.service;

import com.javacode.javacode_test.dto.GetWalletInfo;
import com.javacode.javacode_test.dto.UpdateBalance;
import com.javacode.javacode_test.model.BankAccount;

import java.util.UUID;

public interface BankAccountService {

    public GetWalletInfo updateBalanceOfBankAccount(UpdateBalance updateBalance);
    public GetWalletInfo getBankAccountByUUID(UUID uuid);
}
