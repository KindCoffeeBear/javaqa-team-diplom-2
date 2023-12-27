package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAnExceptionMustBeThrownWhenMinGreaterMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    20_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldAnExceptionMustBeThrownWhenNegativePercent() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -5);
        });
    }

    @Test
    public void shouldAnExceptionMustBeThrownWhenInitialLessMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    3_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldAnExceptionMustBeThrownWhenInitialGreaterMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    20_000,
                    1_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldAnExceptionMustBeThrownWhenMinNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldReturnFalseForNullAmountPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        boolean expected = false;
        boolean actual = account.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewBalanceForNullAmountPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        account.pay(0);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseForNegativeAmountPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        boolean expected = false;
        boolean actual = account.pay(-1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewBalanceForNegativeAmountPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        account.pay(-1_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForPositiveAmountPay() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5);

        boolean expected = true;
        boolean actual = account.pay(1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewBalanceForPositiveAmountPay() {
        SavingAccount account = new SavingAccount(
                50_000,
                10_000,
                100_000,
                5);

        account.pay(10_000);

        int expected = 40_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseForNullAmountAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        boolean expected = false;
        boolean actual = account.add(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewBalanceForNullAmountAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        account.add(0);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseForNegativeAmountAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        boolean expected = false;
        boolean actual = account.add(-1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewBalanceForNegativeAmountAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        account.add(-1_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForPositiveAmountAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        boolean expected = true;
        boolean actual = account.add(1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewBalanceForPositiveAmountAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        account.add(1_000);

        int expected = 3_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseForPositiveAmountWhenNewGreaterMax() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        boolean expected = false;
        boolean actual = account.add(20_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateYearChange() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        int expected = 100;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChangeWithZeroMinBalance() {
        SavingAccount account = new SavingAccount(
                5,
                0,
                10_000,
                5
        );

        int expected = 2;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForPositiveAmountWhenNewEqualsMin() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5);

        boolean expected = true;
        boolean actual = account.pay(4_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewBalanceForPositiveAmountWhenNewEqualsMin() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5);

        account.pay(4_000);

        int expected = 1_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForPositiveAmountWhenNewEqualsMax() {
        SavingAccount account = new SavingAccount(
                50_000,
                10_000,
                100_000,
                5);

        boolean expected = true;
        boolean actual = account.add(50_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewBalanceForPositiveAmountWhenNewEqualsMax() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5);

        account.add(5_000);

        int expected = 10_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
}



