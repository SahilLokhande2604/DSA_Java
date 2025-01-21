import java.util.*;

public class houseRobbery {

    public static long robberyRec(int[] arr, int index){
        if(index<0){
            return 0;
        }
        if(index==0){
            return arr[0];
        }

        long include=robberyRec(arr, index-2) + arr[index];
        long exclude=robberyRec(arr, index-1);

        return (long)Math.max(include, exclude);
    }

    public static long robberyRecMemo(int[] arr, long[] dp, int index){
        if(index<0){
            return 0;
        }
        if(index==0){
            return arr[0];
        }

        if(dp[index]!=-1){
            return dp[index];
        }

        long include=robberyRecMemo(arr, dp, index-2) + arr[index];
        long exclude=robberyRecMemo(arr, dp, index-1);

        dp[index]=Math.max(include,exclude);

        return dp[index];
    }

    public static long robberyTabulation(int[] arr){
        if(arr.length==1){
            return (long)arr[0];
        }

        long[] dp=new long[arr.length];
        dp[0]=arr[0];
        dp[1]=arr[1];

        for(int i=2;i<arr.length;i++){
            long include=dp[i-2] + arr[i];
            long exclude=dp[i-1];
            
            dp[i]=Math.max(include,exclude);
        }

        return dp[arr.length-1];
    }

    public static void robbery(int[] arr){
        // create 2 arr one which has 0 to n-2 index elements i.e. not includeing the last element
        //2nd which has 1 to n-1 index elements i.e. not include the 1st element
        int n=arr.length;
        int[] arr1=new int[n-1];
        int[] arr2=new int[n-1];

        for(int i=1;i<n;i++){
            arr1[i-1]=arr[i];
        }
        for(int i=0;i<n-1;i++){
            arr2[i]=arr[i];
        }
        
        System.out.println("Using Recursion");
        long includeFirst=robberyRec(arr1, n-2);
        long includeLast=robberyRec(arr2, n-2);

        System.out.println(Math.max(includeFirst,includeLast));

        long[] dp1=new long[n-1];
        long[] dp2=new long[n-1];

        for(int i=1;i<n;i++){
            dp1[i-1]=-1;
        }
        for(int i=0;i<n-1;i++){
            dp2[i]=-1;
        }
        
        System.out.println("Using Recursion+Memonization");
        includeFirst=robberyRecMemo(arr1,dp1, n-2);
        includeLast=robberyRecMemo(arr2,dp2, n-2);

        System.out.println(Math.max(includeFirst,includeLast));

        System.out.println("Using Tabulation");
        includeFirst=robberyTabulation(arr1);
        includeLast=robberyTabulation(arr2);

        System.out.println(Math.max(includeFirst,includeLast));
        
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        robbery(arr);

    }
}
