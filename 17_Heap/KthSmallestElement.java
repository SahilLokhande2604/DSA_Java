import java.util.*;
public class KthSmallestElement {

    public int kthSmallestElement(int[] arr, int k){
        int ans=-1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Step 1: Enter first k elements of array into max heap
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        // Step 2: Iterate from kth index of array till end and check if any small element exist then 
        // remove largest element from max. heap and then add the smallest element into it
        for(int i=k;i<arr.length;i++){
            if(arr[i]<pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        // Step 3: Kth samllest element will be at top of max. heap
        ans=pq.peek();
        return ans;
    }
   public static void main(String[] a){
    Scanner sc = new Scanner( System.in );

    System.out.println("Enter the size of array");
    int size=sc.nextInt();
    int[] arr=new int[size];
    System.out.println("Enter data into array");
    for(int i=0;i<size;i++){
        arr[i]=sc.nextInt();
    }
    System.out.println("Enter the value of k");
    int k=sc.nextInt();

    KthSmallestElement kse=new KthSmallestElement();
    int kthElement=kse.kthSmallestElement(arr,k);
    System.out.println("Kth samllest element is "+kthElement);
   } 
}
