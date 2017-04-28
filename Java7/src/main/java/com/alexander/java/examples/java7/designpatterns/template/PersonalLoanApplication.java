package com.alexander.java.examples.java7.designpatterns.template;

/**
 * Created by alexhopgood on 28/04/17.
 */
public class PersonalLoanApplication extends LoanApplication {
    @Override
    protected void checkIdentity() throws ApplicationDenied {
        System.out.println("Checking provided bills and bank statements");
    }

    @Override
    protected void checkIncomeHistory() throws ApplicationDenied {
        System.out.println("Checking employment and payslips");
    }

    @Override
    protected void checkCreditHistory() throws ApplicationDenied {
        System.out.println("Using dubious third party to check credit history");
    }

    @Override
    protected void reportFindings() {

    }
}
