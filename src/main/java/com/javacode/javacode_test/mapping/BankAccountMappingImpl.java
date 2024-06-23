package com.javacode.javacode_test.mapping;

import com.javacode.javacode_test.dto.GetWalletInfo;
import com.javacode.javacode_test.model.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMappingImpl implements BankAccountMapping{

    @Override
    public GetWalletInfo BankAccountToGetWalletInfoMap(BankAccount bankAccount) {

        GetWalletInfo getWalletInfo = new GetWalletInfo();
        getWalletInfo.setWalletId(bankAccount.getWalletId());
        getWalletInfo.setAccountBalance(bankAccount.getAccountBalance());
        getWalletInfo.setClientName(bankAccount.getClientName());
        return getWalletInfo;
    }
}
