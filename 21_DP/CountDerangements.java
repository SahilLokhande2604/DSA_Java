import java.util.*;

public class CountDerangements {

    public static int MOD=1000000007;

    private static long recursive(int n){
        // base case
        if(n==1){
            return 0L;
        }
        if(n==2){
            return 1L;
        }

        long ans=((n-1)*((recursive(n-1)%MOD) + (recursive(n-2)%MOD)))%MOD;

        return ans;
    }

    private static long recMemo(int n, long[] dp){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        long ans=((n-1)*((recMemo(n-1, dp)%MOD) + (recMemo(n-2, dp)%MOD))%MOD)%MOD;
        dp[n]=ans;
        return dp[n];
    }

    private static long tabulation(int n){
        long[] dp=new long[n+1];
        dp[1]=0;
        dp[2]=1;

        for(int i=3;i<=n;i++){
            long n1=(dp[i-1]);
            long n2=(dp[i-2]);

            long ans=((i-1)*((n1+n2)%MOD)%MOD);
            dp[i]=ans;
        }

        return dp[n];
    }

    public static void countDerangements(int n){
        System.out.println("Total no. of possible derangements are as follows");
        System.out.print("Using Recursive Approach : ");
        System.out.println(recursive(n));
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        System.out.print("Using Recursive+Memonization Approach : ");
        System.out.println(recMemo(n,dp));
        System.out.print("Using Tabulation Approach : ");
        System.out.println(tabulation(n));
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=sc.nextInt();

        countDerangements(n);

    }
}
