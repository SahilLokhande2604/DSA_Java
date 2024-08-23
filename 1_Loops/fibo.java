import java.util.*;
public class fibo{
    public static void fiboSeries(int n){
        int a=0;
        int b=1;
        System.out.print(a+" ");
        System.out.print(b+" ");
        for(int i=1;i<=(n-2);i++){
            int sum=a+b;
            System.out.print(sum+" ");
            a=b;
            b=sum;
            
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the no. of terms to print in fibonaci series");
        n=sc.nextInt();
        sc.close();
        fiboSeries(n);
    }
}