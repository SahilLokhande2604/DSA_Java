package Functions;
import java.util.*;
public class prime_or_not {

    public static boolean isPrime(int num){
        for(int i=2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to check wheteher it is prime or not");
        int n=sc.nextInt();
        boolean flag=isPrime(n);
        System.out.println("The number "+n+" is prime. -> "+flag);
    }
}
