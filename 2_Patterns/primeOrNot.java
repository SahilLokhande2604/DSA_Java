import java.util.*;
public class primeOrNot{
    public static void isPrime(int n){
        boolean flag=true;
        for(int i=2;i<n;i++){
            if(n%i==0){
                System.out.println(n+" is not a prime no.");
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println(n+" is prime no.");
        }
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the no. ");
        n=sc.nextInt();
        isPrime(n);
         System.out.println("Enter the no. ");
        n=sc.nextInt();
        isPrime(n);

    }
}