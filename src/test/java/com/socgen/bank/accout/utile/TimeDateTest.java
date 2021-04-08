package com.socgen.bank.accout.utile;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TimeDateTest {

    @Test
    public void convert_ToDays_date_to_dd_MM_yyyy(){
        TimeDate timeDate = new TestableTimeDate();
        String date = timeDate.toDayAsString();
        assertThat(date, is("08/04/2021"));
    }

    private class TestableTimeDate extends TimeDate {
        @Override
        protected LocalDate toDay() {
            return LocalDate.of(2021,04,8);
        }
    }
}