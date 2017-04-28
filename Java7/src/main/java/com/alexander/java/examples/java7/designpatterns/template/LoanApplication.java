package com.alexander.java.examples.java7.designpatterns.template;

/**
 * Created by alexhopgood on 28/04/17.
 */
public abstract class LoanApplication {
    public void checkLoanApplication() throws ApplicationDenied {
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity() throws ApplicationDenied;

    protected abstract void checkIncomeHistory() throws ApplicationDenied;

    protected abstract void checkCreditHistory() throws ApplicationDenied;

    protected abstract void reportFindings();
}
