import java.util.Scanner;

public class fibonachiSeries {
    public static int fibo(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        int ans=fibo(n-1)+fibo(n-2);
        return ans;
    }
     public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of 'n' to get the nth fibonachi term");
        int n=sc.nextInt();
        int ans=fibo(n);
        System.out.println("The "+n+"th fibo term is "+ans);
       
     }
}
