import java.util.*;
public class temp {
    public static int solve(int[] arr){
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            if(pq.size()<3){
                pq.add(arr[i]);
            }
            else if(arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
    public static void main(String[] a){
        int[] arr={1,6,2,8,9,10,2,4,5};
       
        System.out.println(solve(arr));
        Arrays.sort(arr);
       for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
       }
    }
}
