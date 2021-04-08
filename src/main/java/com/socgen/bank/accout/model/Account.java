package com.socgen.bank.accout.model;

import com.socgen.bank.accout.repository.TransactionRepository;
import com.socgen.bank.accout.services.AccountStatement;


public class Account {

    TransactionRepository transactionRepository;
    AccountStatement accountStatement;

    public Account(TransactionRepository transactionRepository,
                     AccountStatement accountStatement) {
        this.transactionRepository = transactionRepository;
        this.accountStatement = accountStatement;
    }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdrawal(int amount) {
        transactionRepository.addWithdrawal(amount);
       }

    public void printStatement() {
        accountStatement.print(transactionRepository.allOperations());
    }
}
