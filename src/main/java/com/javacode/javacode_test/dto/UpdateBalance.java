package com.javacode.javacode_test.dto;

import java.util.UUID;

public class UpdateBalance {

    private UUID walletUUID;
    private DepositOrWithdraw operationType;
    private double amount;

    public UpdateBalance(UUID walletUUID, DepositOrWithdraw operationType, double amount) {
        this.walletUUID = walletUUID;
        this.operationType = operationType;
        this.amount = amount;
    }

    public UUID getWalletUUID() {
        return walletUUID;
    }

    public void setWalletUUID(UUID walletUUID) {
        this.walletUUID = walletUUID;
    }

    public DepositOrWithdraw getOperationType() {
        return operationType;
    }

    public void setOperationType(DepositOrWithdraw operationType) {
        this.operationType = operationType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

