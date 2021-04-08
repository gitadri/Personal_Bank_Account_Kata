package com.socgen.bank.accout.utile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeDate {

    public static final DateTimeFormatter DD_MM_yyyy = DateTimeFormatter.ofPattern("dd/MM/yyy");
    public String toDayAsString() {
        return toDay().format(DD_MM_yyyy);
    }

    protected LocalDate toDay() {
        return LocalDate.now();
    }
}
