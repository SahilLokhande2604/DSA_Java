// Given n ropes f diff length your task is to connect then together to form a simgle rope in min. cost
// cost to connect 2 ropes is sum of there lengths

import java.util.*;
public class MinCostOfRopes {

    public int minCost(int[] ropes, int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(ropes[i]);
        }
        int cost=0;
        while(pq.size()>1){
            int rope1=pq.poll();
            int rope2=pq.poll();
            cost+=rope1 + rope2;
            pq.add(rope1+rope2);
        }
        return cost;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of ropes");
        int NoRopes=sc.nextInt();
        System.out.println("Enter the size of each rope");
        int[] ropes=new int[NoRopes];
        for(int i=0;i<NoRopes;i++){
            ropes[i]=sc.nextInt();
        }

        MinCostOfRopes mcr=new MinCostOfRopes();
        int cost=mcr.minCost(ropes, NoRopes);
        System.out.println("Min. cost to connect "+NoRopes+" ropes is "+cost);

    }
}
