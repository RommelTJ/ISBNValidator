package com.rommelrico.loans;

import org.junit.jupiter.api.*;
import org.mockito.*;

import java.math.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RepaymentAmountTests {

    @Spy
    LoanApplication loanApplication;

    @Test
    void test1YearLoanWholeDollars() {
        loanApplication = spy(new LoanApplication());
        loanApplication.setTermInMonths(12);
        loanApplication.setPrincipal(1200);
        doReturn(new BigDecimal(10)).when(loanApplication).getInterestRate();
        // Expected Repayment = 100

        LoanCalculatorController controller = new LoanCalculatorController();
        controller.processNewLoanApplication(loanApplication);

        assertEquals(new BigDecimal(100), loanApplication.getRepayment());
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
