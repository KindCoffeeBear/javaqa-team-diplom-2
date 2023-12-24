package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWithNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    100,
                    -1,
                    15
            );
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    100,
                    5_000,
                    -1
            );
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithAllNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -100,
                    -5_000,
                    -1
            );
        });
    }

    @Test
    public void shouldPayAndChangeBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        boolean actual = account.pay(3_000);

        int expected = -2_900;

        Assertions.assertTrue(actual);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldPayWithZeroBalanceAndChangeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean actual = account.pay(3_000);

        int expected = -3_000;

        Assertions.assertTrue(actual);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldPayWithNewBalanceEqualsCreditLimitAndChangeBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        boolean actual = account.pay(5_100);

        int expected = -5_000;

        Assertions.assertTrue(actual);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldNotPayWithNegativeAmountAndNotChangeBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        boolean actual = account.pay(-1);

        int expected = 100;

        Assertions.assertFalse(actual);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldNotPayWithNewBalanceLessThanCreditLimitAndNotChangeBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        boolean actual = account.pay(5_101);

        int expected = 100;

        Assertions.assertFalse(actual);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        boolean actual = account.add(3_000);

        int expected = 3_100;

        Assertions.assertTrue(actual);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(100);

        boolean actual = account.add(3_000);

        int expected = 2_900;

        Assertions.assertTrue(actual);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean actual = account.add(3_000);

        int expected = 3_000;

        Assertions.assertTrue(actual);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldNotAddWithNegativeAmount() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        boolean actual = account.add(-3_000);

        int expected = 100;

        Assertions.assertFalse(actual);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldNotYearChangeWithPositiveBalanceEquals50() {
        CreditAccount account = new CreditAccount(
                50,
                5_000,
                67
        );

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotYearChangeWithPositiveBalanceEquals100() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                67
        );

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChangeWithNegativeBalanceEqualsMinus200() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(200);

        int expected = -30;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChangeWithNegativeBalanceEqualsMinus50() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                67
        );

        account.pay(50);

        int expected = -33;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotYearChangeWithZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                67
        );

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                67
        );

        int expected = 5_000;
        int actual = account.getCreditLimit();

        Assertions.assertEquals(expected, actual);
    }
}
