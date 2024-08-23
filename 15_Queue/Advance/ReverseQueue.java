import java.util.*;
public class ReverseQueue{

    public void reverse(Queue<Integer>queue){
        if(queue.isEmpty()){
            return;
        }
        int top=queue.poll();
        reverse(queue);
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
        ReverseQueue reverse=new ReverseQueue();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Queue");
        int n=sc.nextInt();
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            queue.add(i+1);
        }
        reverse.display(queue);

        reverse.reverse(queue);
        reverse.display(queue);


    }
}