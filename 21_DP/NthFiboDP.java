import java.util.*;

public class NthFiboDP {

    // Regular Recursive Approach 
    private int fibo1(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        return ( fibo1(n-1) + fibo1(n-2) );
    }

    // Recursive + Memonization
    private int fibo2(int n,int[] dp){
        // base case
        if(n<=1){
            return n;
        }
        // using dp array to avoid overlaping function calls
        if(dp[n]!=-1){
            return dp[n];
        }

        // storing the solution for ith fibo no.
        dp[n]= fibo2(n-1, dp) + fibo2(n-2, dp);

        return dp[n];
    }

    // Tabulation
    private int fibo3(int n){
        int[] dp=new int[n+1];
        // base case
        dp[0]=0;
        dp[1]=1;

        // calculate dp[i]=dp[i-1]+dp[i-2]
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // Optimize 
    private int fibo4(int n){
        int prev2=0; //i.e. n-2
        int prev1=1; //i.e. n-1

        for(int i=2;i<=n;i++){
            int curr=prev1 + prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;

    }

    public void fibo(int n){
        System.out.println(fibo1(n));

        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }

        System.out.println(fibo2(n,dp));

        System.out.println(fibo3(n));

        System.out.println(fibo4(n));
    }

    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of 'n' to get nth fibo no.");
        int n = sc.nextInt();

        NthFiboDP fib = new NthFiboDP();

        fib.fibo(n);
    }
}
