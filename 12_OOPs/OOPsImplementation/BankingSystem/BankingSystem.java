package BankingSystem;
import java.util.*;
public class BankingSystem {
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome in the Banking System");

        // boolean flag=true;
        // while(flag){
        //     System.out.println("Enter 1 to create a Bank");
        //     System.out.println("Enter 2 to add customer into bank");
        //     System.out.println("Enter 3 to create account of customer");

        //     System.out.println("Enter 4 to perfor operations on account");

        //     // System.out.println("Enter 4 to deposit money in account");
        //     // System.out.println("Enter 5 to withdraw money from account");
        //     System.out.println("Enter 0 to stop");

        //     int key=sc.nextInt();
        //     switch(key){
                
        //         case 1: 
        //             System.out.println("Enter the bank name");
        //             Bank newbank=new Bank(sc.nextLine());

        //             System.out.println("Enter 2 to add customer into bank");
        //             System.out.println("Enter 3 to create account of customer");

        //             int key2=sc.nextInt();
        //             switch(key2){

        //                 case 2: 
        //                     System.out.println("Enter the customer name");
        //                     newbank.registerCustomer(sc.nextLine());
        //                     break;
                        
        //                 case 3:
        //                     System.out.println("Enter the customer details to create account");
        //                     System.out.println("Enter the customer id");
        //                     int customerId=sc.nextInt();
        //                     System.out.println("Enter the type of account");
        //                     String type=sc.nextLine();
        //                     System.out.println("Enter the amount you are depositing in account");
        //                     int amount=sc.nextInt();
        //                     System.out.println("Enter the interest rate");
        //                     int interestRate=sc.nextInt();
        //                     System.out.println("Enter the overdraftLimit if applicable else enter 0");
        //                     int overdraftLimit=sc.nextInt();

        //                     newbank.createAccount(customerId, type, amount, interestRate, overdraftLimit);

                        
                    
        //             }

        //             break;
                
        //         case 2:
                    

        //     }
        // }

        // Bank bank = new Bank("ABC Bank");

        // // Register customers
        // Customer customer1 = bank.registerCustomer("John Doe");
        // Customer customer2 = bank.registerCustomer("Jane Smith");

        // // Create Savings and Current accounts
        // bank.createAccount(customer1.getCustomerId(), "Savings", 1000, 2.5, 0);
        // bank.createAccount(customer2.getCustomerId(), "Current", 500, 0, 1000);

        // // Perform operations on John's savings account
        // Account johnSavings = customer1.getAccount(1);
        // if (johnSavings != null) {
        //     johnSavings.deposit(500);
        //     ((SavingsAccount) johnSavings).addInterest();
        //     System.out.println("John's balance: $" + johnSavings.checkBalance());
        // }

        // // Perform operations on Jane's current account
        // Account janeCurrent = customer2.getAccount(2);
        // if (janeCurrent != null) {
        //     janeCurrent.withdraw(600);
        //     System.out.println("Jane's balance: $" + janeCurrent.checkBalance());
        // }
    } 
}
