package BankingSystem;
import java.util.*;


class Account{
    private int accountNo;
    private String accountHolderName;
    protected double balance;

    Account(int accountNo, String accountHolderName, double balance){
        this.accountNo=accountNo;
        this.accountHolderName=accountHolderName;
        this.balance=balance;
    }

    public void deposit(double amount){
        if(amount>0){
            this.balance+=amount;
            System.out.println("Amount deposited successfully in your account");
        }
        else{
            System.out.println("Please provide amount greater than 0");
        }
    }

    public void withdraw(double amount){
        if(amount>0 && (this.balance-amount) >=0 ){
            this.balance-=amount;
            System.out.println("Amount Rs."+amount+" withdraw successfully from your account");
        } 
        else if((this.balance-amount) < 0){
            System.out.println("Your account does not have required balance to withdraw please check your balance");
        }
        else{
            System.out.println("Please enter amount greater than 0");
        }
    }

    public int getAccountNo(){
        return this.accountNo;
    }

    public double checkBalance(){
        return this.balance;
    }

    public String getAccountHolderName(){
        return this.accountHolderName;
    }
}


class SavingsAccount extends Account{
    private double interestRate;

    SavingsAccount(int accountNo, String accountHolderName, double balance, double interestRate){
        super(accountNo, accountHolderName, balance);
        this.interestRate=interestRate;
    }

    public void addInterest(){
        double interest=(this.balance * interestRate )/100;

        this.balance+=interest;
        System.out.println("Your account gets creadited with interest amount of Rs."+interest+" successfully");
    }
}

class CurrentAccount extends Account{
    private int overdraftLimit;

    CurrentAccount(int accountNo, String accountHolderName, double balance, int overdraftLimit){
        super(accountNo,accountHolderName,balance);
        this.overdraftLimit=overdraftLimit;
    }

    @Override
    public void withdraw(double amount){
        if(amount>0 && (this.balance - amount ) >= -overdraftLimit){
            this.balance-=amount;
            System.out.println("Your account has overDrafted with amount "+amount+" successfully");
        }
        else{
            System.out.println("Overdraft limit exceed");
        }
    }
}