package com.socgen.bank.accout.repository;

import com.socgen.bank.accout.model.Operation;
import com.socgen.bank.accout.utile.TimeDate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class TransactionRepository {
    private final TimeDate timeDate;
    private List<Operation> operations =new ArrayList<>();

    public TransactionRepository(TimeDate timeDate) {
        this.timeDate=timeDate;
    }

    //connection with a data base (mongoDB for example)
    //Or send a post http request if we call an API REST
    public void addDeposit(int amount) {
        //insert
        Operation deposit = new Operation(timeDate.toDayAsString(),amount);
        operations.add(deposit);
    }

    public void addWithdrawal(int amount) {
        //insert
        Operation withdrawal = new Operation(timeDate.toDayAsString(),amount);
        operations.add(withdrawal);
    }

    public List<Operation> allOperations() {
        //fetchAll
        return unmodifiableList(operations);
    }
}
