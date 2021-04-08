package com.socgen.bank.accout.model;

import com.socgen.bank.accout.repository.TransactionRepository;
import com.socgen.bank.accout.services.AccountStatement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock TransactionRepository transactionRepository;
    private Account account;
    @Mock AccountStatement accountStatement;

    @Before
    public void initilise(){
        //in the acceptance Test i will use the real repository
        //And in the unit test i will Moecked
        account = new Account(transactionRepository, accountStatement);
    }

    @Test
    public void save_deposit_operation(){
        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }
    @Test
    public void save_withdrawal_operation(){
        account.withdrawal(100);
        verify(transactionRepository).addWithdrawal(100);
    }

    @Test
    public void print_statement(){

        List<Operation> operations = asList(new Operation("07/04/2021",100));
        //when the transactionRepository.allOperations() will return all ooperations
        given(transactionRepository.allOperations()).willReturn(operations);

        //when call printStatment for the account I expect a list of transaction
        account.printStatement();

        //I verufy the accountStatment Class was called with the transactioins
        //that came from the repository
        verify(accountStatement).print(operations);
    }

}