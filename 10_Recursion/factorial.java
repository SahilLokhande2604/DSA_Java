import java.util.*;
public class factorial{

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of n to get its factorial ");
        int n=sc.nextInt();
        int ans=fact(n);
        System.out.println(n+"! = "+ans);

    }
}