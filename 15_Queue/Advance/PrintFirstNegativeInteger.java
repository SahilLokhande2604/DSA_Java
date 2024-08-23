// Question: Given array of size n find the first negative integer from a window of size k and store it in array ans
import java.util.*;
public class PrintFirstNegativeInteger {

    public int[] firstNegativeInteger(int[] arr,int n,int k){
       
        ArrayList<Integer>ans=new ArrayList<>();
        Deque<Integer>dq=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                dq.push(i);
            }
        }
        if(!dq.isEmpty()){
            ans.add(arr[dq.peekFirst()]);
        }
        else{
            ans.add(0);
        }

        for(int i=k;i<n;i++){
            if(!dq.isEmpty() && ( ( i-dq.peek() ) >= k ) ){
                dq.pop();
            }
            if(arr[i]<0){
                // dq.push(i);
                dq.addLast(i);
            }
            if(dq.isEmpty()){
                ans.add(0);
            }
            else{
            ans.add(arr[dq.peekFirst()]);
            }
        }

        int[] ansArr=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ansArr[i]=ans.get(i);
        }
        return ansArr;
    }
    public void display(int[] arr){
        // System.out.println("Array is ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintFirstNegativeInteger fun=new PrintFirstNegativeInteger();
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the size of window(k)");
        int k=sc.nextInt();
        
        fun.display(arr);

        int[] ans=fun.firstNegativeInteger(arr, n, k);
        System.out.println("First negative integer in a window of size k is as below");
        fun.display(ans);
    }
}
