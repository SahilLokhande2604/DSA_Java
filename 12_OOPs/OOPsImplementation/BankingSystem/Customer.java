package BankingSystem;
import java.util.*;

public class Customer {
    private int customerId;
    private String customerName;
    private List<Account> accounts;

    Customer(int customerId, String customerName){
        this.customerId=customerId;
        this.customerName=customerName;
        this.accounts=new ArrayList<Account>();
    }

    public void addAccount(Account account){
        accounts.add(account);
        System.out.println("Account added successfully");
    }

    public Account getAccount(int accountNo){
        Account account=null;

        for(Account customerAccount: accounts){
            if(customerAccount.getAccountNo()==accountNo){
                return customerAccount;
            }
        }

        return account;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public int getCustomerId(){
        return this.customerId;
    }

}
