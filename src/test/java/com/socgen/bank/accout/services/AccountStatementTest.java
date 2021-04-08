package com.socgen.bank.accout.services;

import com.socgen.bank.accout.model.Operation;
import com.socgen.bank.accout.utile.Printer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)
public class AccountStatementTest {

    @Mock
    Printer printer;
    private List<Operation> No_Operations = Collections.EMPTY_LIST;

    @Test
    public void always_print_the_header(){
        AccountStatement accountStatement = new AccountStatement(printer);
        accountStatement.print(No_Operations);
        verify(printer).printLine("Date || Amount || Balance");
    }
    @Test
    public void print_in_chronological_hustory_order(){
        AccountStatement accountStatement = new AccountStatement(printer);

        List<Operation> operations = operationsContaning(
            deposit("02/11/2020",1000),
            withdrawal("06/02/2021",-100),
            deposit("07/04/2021",500)
        );
        accountStatement.print(operations);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).printLine("Date || Amount || Balance");
        inOrder.verify(printer).printLine("02/11/2020 || 1000,00 || 1000,00");
        inOrder.verify(printer).printLine("06/02/2021 || -100,00 || 900,00");
        inOrder.verify(printer).printLine("07/04/2021 || 500,00 || 1400,00");


    }

    private List<Operation> operationsContaning(Operation... operations) {
        return Arrays.asList(operations);
    }

    private Operation deposit(String date, int amount) {
        return new Operation(date, amount);
    }
    private Operation withdrawal(String date, int amount) {
        return new Operation(date, amount);
    }
}