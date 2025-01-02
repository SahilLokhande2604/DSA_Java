package BankingSystem;
import java.util.*;

public class Bank {
    private String bankName;
    private List<Customer>customers;

    Bank(String bankName){
        this.bankName=bankName;
        this.customers=new ArrayList<>();
    }

    public Customer registerCustomer(String name){
        int customerId=this.customers.size()+1;
        String customerName=name;

        Customer customer=new Customer(customerId, customerName);
        customers.add(customer);
        System.out.println("Customer Registration Done Successfully");
        return customer;
    }

    public Account createAccount(int customerId, String accountType, double initialDeposit, double interestRate, int overdraftRate){
        
        // find the customer with customerId
        Customer customer=findCustomer(customerId);

        if(customer!=null){
            if(accountType.equals("Savings") || accountType.equals("savings")){
                Account newAccount=new SavingsAccount(customer.getCustomerId(), customer.getCustomerName(), initialDeposit, interestRate);
                customer.addAccount(newAccount);
                System.out.println("Account added successfully in customer details");
                return newAccount;
            }
            else{
                Account newAccount=new CurrentAccount(customer.getCustomerId(), customer.getCustomerName(), initialDeposit, overdraftRate);
                customer.addAccount(newAccount);
                System.out.println("Account added successfully in customer details");
                return newAccount;
            }
        }
        else{
            System.out.println("Customer does not exist");
            return null;
        }
        
        
    }

    public Customer findCustomer(int customerId){
        for(Customer customer: customers){
            if(customer.getCustomerId()==customerId){
                return customer;
            }
        }
        return null;
    }
}
