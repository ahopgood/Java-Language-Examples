package com.alexander.java.example.java8.designpatterns.template;

/**
 * Created by alexhopgood on 28/04/17.
 */
public interface Company {

    public void checkIdentity() throws ApplicationDenied;

    public void checkIncomeHistory() throws ApplicationDenied;

    public void checkCreditHistory() throws ApplicationDenied;
}
