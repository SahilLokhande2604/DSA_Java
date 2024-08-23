package Functions;
import java.util.*;
public class ap {

    public static int Nth_term(int a,int d,int n){
        int an=a+((n-1)*d);
        return an;
    }
   public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the value of a ");
    int a=sc.nextInt();
    System.out.println("Enter the value of d (i.e. common difference) ");
    int d=sc.nextInt();
    System.out.println("Enter the value of n (i.e. nth term) ");
    int n=sc.nextInt();

    int ans=Nth_term(a, d, n);
    System.out.println("The nth term value is "+ans);
   } 
}
