package com.socgen.bank.accout.services;


import com.socgen.bank.accout.model.Operation;
import com.socgen.bank.accout.utile.Printer;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AccountStatement {

    private Printer printer;
    public static final String STATEMENT_HEADER = "Date || Amount || Balance";
    private DecimalFormat decimalFormatter = new DecimalFormat("#.00");

    public AccountStatement(Printer printer) {
        this.printer=printer;
    }

    public void print(List<Operation> operations) {
        printer.printLine(STATEMENT_HEADER);
        AtomicInteger runningBalance= new AtomicInteger(0);
        operations.stream()
                .map(operation -> statementOperation(operation,runningBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .forEach(printer::printLine);
    }

    private String statementOperation(Operation operation, AtomicInteger runningBalance) {
        return operation.date()
                +" || "
                + decimalFormatter.format(operation.amount())
                +" || "
                + decimalFormatter.format(runningBalance.addAndGet(operation.amount()));
    }

}
