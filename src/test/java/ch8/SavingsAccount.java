package ch8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PassbookTest {
    SavingsAccount testAccount;

    @BeforeEach
    void setUp() {
        testAccount = new SavingsAccount(0.05);
        testAccount.deposit(100);
    }


    @Test
    void deposit() {
        var oldBal = testAccount.getBalance();
        var addedAmount = 100.0;
        testAccount.deposit(addedAmount);
        var newBal = testAccount.getBalance();

        Assertions.assertThat(newBal).isEqualTo(oldBal + addedAmount);
    }

    @Test
    void depositNegative() {
        assertThatThrownBy(() -> testAccount.deposit(-2131)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void withdraw() {
        var oldBal = testAccount.getBalance();
        var withdrawnAmount = 100.0;
        testAccount.withdraw(withdrawnAmount);
        var newBal = testAccount.getBalance();

        Assertions.assertThat(newBal).isEqualTo(oldBal - withdrawnAmount);
    }

    @Test
    void withdrawNegative() {
        assertThatThrownBy(() -> testAccount.withdraw(-2131)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void withdrawOverBalance() {
        assertThatThrownBy(() -> testAccount.withdraw(200)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void getYield() {
        var years = 1;
        var calculatedYield = testAccount.getYield(1);

        Assertions.assertThat(calculatedYield).isEqualTo(105);
    }

    @Test
    void getYieldNegative() {
        assertThatThrownBy(() -> testAccount.getYield(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addAnnualInterest() {
        var oldBal = testAccount.getBalance();
        var interestRate = testAccount.getInterestRate();
        testAccount.addAnnualInterest();
        var newBal = testAccount.getBalance();

        Assertions.assertThat(newBal).isEqualTo(oldBal * (1 + interestRate));
    }
}