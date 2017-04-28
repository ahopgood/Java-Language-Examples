package com.alexander.java.example.java8.designpatterns.template;

/**
 * Created by alexhopgood on 28/04/17.
 */
public class CompanyLoanApplication extends LoanApplication {

    //Companies will follow the same steps to do loan application but we want to pass in
    //Criterias encapsultated within a Company object so we can reflect the needs of
    //different countries -> e.g. checkIdentiy = companies house in the uk, in the US it varies
    public CompanyLoanApplication(Company company) throws ApplicationDenied {
        super(company::checkIdentity, company::checkIncomeHistory, company::checkCreditHistory);
    }


    public static void main(String[] args) throws ApplicationDenied {
        CompanyLoanApplication loan = new CompanyLoanApplication(new UKCompany());
        loan.checlLoanApplication();
    }
}
