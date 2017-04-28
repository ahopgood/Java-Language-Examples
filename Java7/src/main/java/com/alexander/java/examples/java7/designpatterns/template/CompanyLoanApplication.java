package com.alexander.java.examples.java7.designpatterns.template;

/**
 * Created by alexhopgood on 28/04/17.
 */
public class CompanyLoanApplication extends LoanApplication {
    @Override
    protected void checkIdentity() throws ApplicationDenied {
        System.out.println("Checking company identity at Companies House");
    }

    @Override
    protected void checkIncomeHistory() throws ApplicationDenied {
        System.out.println("Checking existing profit and loss statements with balance sheets");
    }

    @Override
    protected void checkCreditHistory() throws ApplicationDenied {
        System.out.println("Checking bad and outstanding debts");
    }

    @Override
    protected void reportFindings() {

    }
}
