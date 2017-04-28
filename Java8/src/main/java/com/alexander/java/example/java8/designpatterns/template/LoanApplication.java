package com.alexander.java.example.java8.designpatterns.template;

/**
 * Created by alexhopgood on 28/04/17.
 */
public class LoanApplication {
    private final Criteria identity;
    private final Criteria creditHistory;
    private final Criteria incomeHistory;

    public LoanApplication(
            Criteria identity,
            Criteria creditHistory,
            Criteria incomeHistory
    ) throws ApplicationDenied {
        this.identity = identity;
        this.creditHistory = creditHistory;
        this.incomeHistory = incomeHistory;
    }

    public void checlLoanApplication() throws ApplicationDenied {
        this.identity.check();
        this.creditHistory.check();
        this.incomeHistory.check();
        reportFindings();
    }

    private void reportFindings(){};


    public static void main(String[] args) throws ApplicationDenied {
        LoanApplication ukCompanyLoan = new LoanApplication(
                () -> System.out.println("Checking company identity at Companies House"),
                () -> System.out.println("Checking existing profit and loss statements with balance sheets"),
                () -> System.out.println("Checking bad and outstanding debts")
        );
        ukCompanyLoan.checlLoanApplication();

        Criteria personalIdentityCheck = () -> System.out.println("Checking provided bills and bank statements");
        Criteria personalCreditHistory = () -> System.out.println("Using dubious third party to check credit history");

        LoanApplication personalLoan = new LoanApplication(
                personalIdentityCheck,
                personalCreditHistory,
                () -> System.out.println("Checking employment and payslips")
        );
        personalLoan.checlLoanApplication();

        LoanApplication employeeLoan = new LoanApplication(
                personalIdentityCheck,
                personalCreditHistory,
                () -> System.out.println("They're our employee, we know they have income")
        );
        employeeLoan.checlLoanApplication();
    }
}
