import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseFirstKElementOfQueue {

    public void reverseK(Queue<Integer>queue,int k){
        reverse(queue,k,0);
        for(int i=0;i<queue.size()-k;i++){
            queue.add(queue.poll());
        }
    }

    public void reverse(Queue<Integer>queue,int k,int count){
        if(count==k){
            return;
        }
        int top=queue.remove();
        reverse(queue, k, count+1);
        queue.add(top);
        

    }


    public void display(Queue<Integer>queue){
        if(queue.isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        int[] arr=new int[queue.size()];
        int i=0;
        while(!queue.isEmpty()){
            arr[i]=queue.poll();
            System.out.print(arr[i++]+" ");
        }
        System.out.println();
        for(i=0;i<arr.length;i++){
            queue.add(arr[i]);
        }
    }
    public static void main(String[] args) {
        ReverseFirstKElementOfQueue reverse=new ReverseFirstKElementOfQueue();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Queue");
        int n=sc.nextInt();
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            queue.add(i+1);
        }
        System.out.println("Enter the value of k to reverse first k elements of queue (k must be positive)");
        int k=sc.nextInt();
        reverse.display(queue);

        reverse.reverseK(queue,k);
        reverse.display(queue);


    }
}
