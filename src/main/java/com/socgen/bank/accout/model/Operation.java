package com.socgen.bank.accout.model;

import com.socgen.bank.accout.utile.TimeDate;

import java.time.LocalDateTime;
import java.util.Objects;


public class Operation {


    private final String date;
    private final int amount;

    public Operation(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    //We should implement equals and hascode beacuase the operations are
    //not the same they will be have different pointers and we will have
    // this error :
    /* java.lang.AssertionError:
       Expected: is <com.socgen.bank.accout.model.Operation@38089a5a>
       but: was <com.socgen.bank.accout.model.Operation@30e868be>*/
    //So we need to implement equals and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(date, operation.date) && Objects.equals(amount, operation.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }

    public String date() {
        return date;
    }

    public int amount() {
        return amount;
    }
}
