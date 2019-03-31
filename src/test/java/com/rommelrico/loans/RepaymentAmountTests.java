package com.rommelrico.loans;

import org.junit.jupiter.api.*;

import java.math.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RepaymentAmountTests {

    @Test
    void test1YearLoanWholeDollars() {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setTermInMonths(12);
        loanApplication.setPrincipal(1200);
        // Interest rate = 10%
        // Expected Repayment = 100

        LoanCalculatorController controller = new LoanCalculatorController();
        controller.processNewLoanApplication(loanApplication);

        assertEquals(new BigDecimal(110), loanApplication.getRepayment());
    }

    @Test
    void test2YearLoanWholeDollars() {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setTermInMonths(24);
        loanApplication.setPrincipal(1200);
        // Interest rate = 10%
        // Expected Repayment = 60

        fail();
    }

    @Test
    void test5YearLoanWithRounding() {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setTermInMonths(60);
        loanApplication.setPrincipal(5000);
        // Interest rate = 6.5%
        // Expected Repayment = 111

        fail();
    }

}
