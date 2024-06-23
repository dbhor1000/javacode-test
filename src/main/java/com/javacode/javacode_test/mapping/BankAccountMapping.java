package com.javacode.javacode_test.mapping;

import com.javacode.javacode_test.dto.GetWalletInfo;
import com.javacode.javacode_test.model.BankAccount;

public interface BankAccountMapping {

    public GetWalletInfo BankAccountToGetWalletInfoMap(BankAccount bankAccount);
}
