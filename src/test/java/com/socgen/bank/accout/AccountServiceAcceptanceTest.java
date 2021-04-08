package com.socgen.bank.accout;


import com.socgen.bank.accout.model.Account;
import com.socgen.bank.accout.repository.TransactionRepository;
import com.socgen.bank.accout.services.AccountStatement;
import com.socgen.bank.accout.utile.Printer;
import com.socgen.bank.accout.utile.TimeDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceAcceptanceTest {

    @Mock
    Printer printer;
    private Account account;
    @Mock TimeDate timeDate;

    @Before
    public void initilise(){
        //in the acceptance Test i will use the real repository
        //And in the unit test i will Moecked
        TransactionRepository transactionRepository = new TransactionRepository(timeDate);
        AccountStatement accountStatement = new AccountStatement(printer);
        account = new Account(transactionRepository, accountStatement);
    }
    //1 start with an acceptance test
    //once the acceptance test is failing for the right reason
    //2 go to the inner loop of TDD of the unit test
    //3 start the unit testing all the classes
    //4 the acceptance test should be green

    @Test
    public void statement_including_all_operation_Test(){
        given(timeDate.toDayAsString()).willReturn("02/11/2020","06/02/2021","07/04/2021");

        account.deposit(1000);
        account.withdrawal(-100);
        account.deposit(500);

        account.printStatement();

        //
        InOrder inOrder = inOrder(printer);
        //also i will make sure that the methode printLine
        // in the console mock is invoked in the right order
        inOrder.verify(printer).printLine("Date || Amount || Balance");
        inOrder.verify(printer).printLine("02/11/2020 || 1000,00 || 1000,00");
        inOrder.verify(printer).printLine("06/02/2021 || -100,00 || 900,00");
        inOrder.verify(printer).printLine("07/04/2021 || 500,00 || 1400,00");
    }






}
