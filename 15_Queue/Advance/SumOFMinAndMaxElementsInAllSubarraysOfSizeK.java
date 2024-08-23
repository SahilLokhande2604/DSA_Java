import java.util.*;
public class SumOFMinAndMaxElementsInAllSubarraysOfSizeK {
    public int sumOfMinAndMaxOfAllSubarrayOfSizeK(int[] arr,int k){
        Deque<Integer>mini=new LinkedList<Integer>();
        Deque<Integer>maxi=new LinkedList<Integer>();

        for(int i=0;i<k;i++){
            while(!mini.isEmpty() && arr[mini.peekLast()]>=arr[i]){
                mini.pollLast();
            }
            while(!maxi.isEmpty() && arr[maxi.peekLast()]<=arr[i]){
                maxi.pollLast();
            }

            mini.addLast(i);
            maxi.addLast(i);
        }
        int ans=0;
        ans+=arr[mini.peekFirst()] + arr[maxi.peekFirst()];


        for(int i=k;i<arr.length;i++){

            // Removal
            while(!mini.isEmpty() && (i-mini.peekFirst())>=k){
                mini.pollFirst();
            }

            while(!maxi.isEmpty() && (i-maxi.peekFirst())>=k){
                maxi.pollFirst();
            }

            // Addition
            while(!mini.isEmpty() && arr[mini.peekLast()]>=arr[i]){
                mini.pollLast();
            }
            while(!maxi.isEmpty() && arr[maxi.peekLast()]<=arr[i]){
                maxi.pollLast();
            }

            mini.addLast(i);
            maxi.addLast(i);

            // Updating ans
            ans+=arr[mini.peekFirst()] + arr[maxi.peekFirst()];

        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size=sc.nextInt();
        System.out.println("Enter elements in the array");
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the value of k (i.e. size of each subarray)");
        int k=sc.nextInt();

        SumOFMinAndMaxElementsInAllSubarraysOfSizeK sum=new SumOFMinAndMaxElementsInAllSubarraysOfSizeK();
        System.out.println("Sum is "+sum.sumOfMinAndMaxOfAllSubarrayOfSizeK(arr,k));

    }
}


// size=7 
// array elements
// 2
// 5
// -1
// 7
// -3
// -1
// -2

// k=4