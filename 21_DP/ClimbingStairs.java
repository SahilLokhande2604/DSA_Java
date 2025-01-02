// Problem Statement: https://leetcode.com/problems/min-cost-climbing-stairs/description/

// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

// Example 1:

// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.

import java.util.*;
public class ClimbingStairs {
    // solution using normal recursion
    public static long minCostToClimbStairs1(int n, int[] cost){
        // base case user can start either from 0th stair or 1st stair
        if(n==0){
            return cost[0];
        }
        if(n==1){
            return cost[1];
        }

        return cost[n] + Math.min(minCostToClimbStairs1(n-1, cost), minCostToClimbStairs1(n-2, cost));
    }

    // using top-down approach i.e. recursion+memonization
    public static long minCostToClimbStairs2(int n, int[] cost, long[] dp){
        // base case
        if(n==0){
            return cost[0];
        }
        if(n==1){
            return cost[1];
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n]= cost[n]+ Math.min(minCostToClimbStairs2(n-1, cost, dp), minCostToClimbStairs2(n-2, cost, dp));

        return dp[n];
    }

    // bottom-up approach approach i.e. tabulation
    public static long minCostToClimbStairs3(int n, int[] cost){
        // create a dp array of size n+1 and store values of base cases
        long[] dp=new long[n+1];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }

        return Math.min(dp[n-1],dp[n-2]);
    }

    // optimize approach 
    public static long minCostToClimbStairs4(int n, int[] cost){
        // base case
        if(n==0){
            return cost[0];
        }
        if(n==1){
            return cost[1];
        }

        long a=cost[0];
        long b=cost[1];

        for(int i=2;i<n;i++){
            long temp= cost[i] + Math.min(a,b);
            a=b;
            b=temp;
        }

        return Math.min(a,b);
    }

    public static void minCostToClimbStairs(int n, int[] cost){
        
        long ans1=Math.min(minCostToClimbStairs1(n-1,cost), minCostToClimbStairs1(n-2,cost));
        System.out.println("Using Recursion: "+ans1);

        long[] dp=new long[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        long ans2=Math.min(minCostToClimbStairs2(n-1, cost, dp), minCostToClimbStairs2(n-2, cost, dp));
        System.out.println("Using Recursion+Memonization: "+ans2);

        long ans3=minCostToClimbStairs3(n,cost);
        System.out.println("Using Tabulation: "+ans3);

        long ans4=minCostToClimbStairs3(n,cost);
        System.out.println("Optimize using variables: "+ans4);

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of stairs");
        int n=sc.nextInt();
        System.out.println("Enter the cost of each stair which climber need to pay to move to next stair starting from 0th stair till n-1 th stair");
        System.out.println("i.e. there will be no cost for nth stair as you are already at nth stair");
        int[] cost=new int[n];
        for(int i=0;i<n;i++){
            cost[i]=sc.nextInt();
        }

        minCostToClimbStairs(n,cost);
    
    }
}
