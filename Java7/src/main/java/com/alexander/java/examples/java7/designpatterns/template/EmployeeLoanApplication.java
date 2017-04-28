package com.alexander.java.examples.java7.designpatterns.template;

/**
 * Created by alexhopgood on 28/04/17.
 */
public class EmployeeLoanApplication extends PersonalLoanApplication {

    @Override
    public void checkIncomeHistory(){
        System.out.println("They're our employee, we know they have income");
    }
}
