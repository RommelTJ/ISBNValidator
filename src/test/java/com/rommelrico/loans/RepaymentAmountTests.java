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
        loanApplication = spy(new LoanApplication());
        loanApplication.setTermInMonths(24);
        loanApplication.setPrincipal(1200);
        doReturn(new BigDecimal(10)).when(loanApplication).getInterestRate();
        // Expected Repayment = 60

        LoanCalculatorController controller = new LoanCalculatorController();
        controller.processNewLoanApplication(loanApplication);

        assertEquals(new BigDecimal(60), loanApplication.getRepayment());
    }

    @Test
    void test5YearLoanWithRounding() {
        loanApplication = spy(new LoanApplication());
        loanApplication.setTermInMonths(60);
        loanApplication.setPrincipal(5000);
        doReturn(new BigDecimal(6.5)).when(loanApplication).getInterestRate();
        // Expected Repayment = 111

        LoanCalculatorController controller = new LoanCalculatorController();
        controller.processNewLoanApplication(loanApplication);

        assertEquals(new BigDecimal(111), loanApplication.getRepayment());
    }

}
