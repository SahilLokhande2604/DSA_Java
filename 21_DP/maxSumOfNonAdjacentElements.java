import java.util.*;

public class maxSumOfNonAdjacentElements {

    public static int maxSumRecursive(int[] arr, int index){
        if(index<0){
            return 0;
        }
        if(index==0){
            return arr[0];
        }

        int include=maxSumRecursive(arr, index-2) + arr[index];
        int exclude=maxSumRecursive(arr, index-1);
        System.out.println(include+" "+exclude+" index="+index);
        return Math.max(include,exclude);
    }

    public static int maxSumRecursiveMemonization(int[] arr, int[] dp, int index){
        if(index<0){
            return 0;
        }
        if(index==0){
            return arr[0];
        }

        if(dp[index]!=-1){
            return dp[index];
        }

        int include=maxSumRecursiveMemonization(arr, dp, index-2) + arr[index];

        int exclude=maxSumRecursiveMemonization(arr, dp, index-1);

        dp[index]=Math.max(include,exclude);

        return dp[index];
    }

    public static int maxSumTabulation(int[] arr){
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        dp[1]=arr[1];

        for(int i=2;i<arr.length;i++){
            int include=dp[i-2]+arr[i];
            int exclude=dp[i-1];
            dp[i]=Math.max(include,exclude);
        }
        return dp[dp.length-1];
    }

    public static void maxSum(int[] arr){
        
        int index=arr.length-1;
        int sum=0;
        int recursiveAns=maxSumRecursive(arr,index);
        System.out.println("Max sum using recursive approach: "+recursiveAns);

        int[] dp=new int[arr.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int recursiveMemonizationAns=maxSumRecursiveMemonization(arr,dp,index);
        System.out.println("Max sum using recursive+memonization approach: "+recursiveMemonizationAns);

        int tabulationAns=maxSumTabulation(arr);
        System.out.println("Max sum using tabulation approach: "+tabulationAns);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        maxSum(arr);


    }
}
