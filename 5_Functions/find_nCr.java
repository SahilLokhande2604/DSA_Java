package Functions;
import java.util.*;
public class find_nCr {

    public static int factorial(int num){
        int fact=1;
        for(int i=1;i<=num;i++){
            fact=fact*i;
            // System.out.println("fact="+fact);
        }
        // System.out.println("___________");
        return fact;
    }

    public static int nCr(int n,int r){
        int N=factorial(n);
        int R=factorial(r);
        int c= n-r;
        System.out.println("The value of c is"+c);
        int C=factorial(c);
        int ans=(N/(R*C));
        return ans;
    }
        public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the value of n and r to calculate value of nCr \nNOTE: n>=r");
            int n=sc.nextInt();
            int r=sc.nextInt();
            int ans=nCr(n, r);
            System.out.println("The value of nCr is "+ans);


        }
}
