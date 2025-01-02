import java.util.*;
public class Fibonachi {

    public static long fiboRecursion(int n){
        // base case
        if(n<=1){
            return n;
        }
        return fiboRecursion(n-1)+fiboRecursion(n-2);
    }

    public static long fiboTopDownApproach(int n, long[] dp){
        // base case 
        if(n<=1){
            return n;
        }

        // if the value is already calculated then simply return it
        if(dp[n]!=-1){
            return dp[n];
        }

        //calculate the value for dp[i] if not calculated 
        dp[n]=fiboTopDownApproach(n-1, dp) + fiboTopDownApproach(n-2, dp);

        return dp[n];
    }


    public static long fiboBottomUpApproach(int n){
        // create a dp of size n+1
        long[] dp=new long[n+1];
        // base case dp[0]=0, dp[1]=1
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            // calculate the value of ith fibo number using sum of i-1th fibo number and i-2th fibo number
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the nth index to get nth fibonachi number i.e. f(0)=0, f(1)=1, f(2)=1,..");
        int n=sc.nextInt();
        // System.out.println("Using Recursion: "+fiboRecursion(n));
        long[] dp=new long[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        System.out.println("Using Top-Down DP i.e. Recursion+Memonization: "+fiboTopDownApproach(n,dp));
        System.out.println("Using Bottom-Up DP i.e. Tabulation: "+fiboBottomUpApproach(n));
    }
}
