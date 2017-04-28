package com.alexander.java.example.java8.designpatterns.template;

/**
 * Created by alexhopgood on 28/04/17.
 */
public class UKCompany implements Company {
    @Override
    public void checkIdentity() throws ApplicationDenied {
        System.out.println("Checking company identity at Companies House");
    }

    @Override
    public void checkIncomeHistory() throws ApplicationDenied {
        System.out.println("Checking existing profit and loss statements with balance sheets");
    }

    @Override
    public void checkCreditHistory() throws ApplicationDenied {
        System.out.println("Checking bad and outstanding debts");
    }
}
