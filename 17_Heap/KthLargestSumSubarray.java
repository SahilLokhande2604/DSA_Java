// your are given a array , return kth largest sum of subarray of given array


import java.util.*;
public class KthLargestSumSubarray {

    public int KthLargestSumofSubArray(int[] arr, int k){
        int n=arr.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(pq.size()<k){
                    pq.add(sum);
                }
                else{
                    if(pq.peek()<sum){
                        pq.remove();
                        pq.add(sum);
                    }
                }
            }
        }

        return pq.peek();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        int size=sc.nextInt();
        System.out.println("Enter elements into array");
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the value of k to get kth largest sum of subarray");
        int k=sc.nextInt();
        KthLargestSumSubarray klsa=new KthLargestSumSubarray();
        int sum=klsa.KthLargestSumofSubArray(arr,k);
        System.out.println("Sum of kth largest subarray is "+sum);
    }
}
