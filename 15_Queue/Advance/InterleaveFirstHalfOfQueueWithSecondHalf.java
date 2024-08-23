import java.util.*;
public class InterleaveFirstHalfOfQueueWithSecondHalf {

    public void interleave(Queue<Integer>queue){
        int half=queue.size()/2;
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<half;i++){
            q.add(queue.poll());
        }
        for(int i=0;i<half;i++){
            queue.add(q.poll());
            queue.add(queue.poll());
        }
    }

    public void display(Queue<Integer>q){
        System.out.println("Queue is ");
        for(int i=0;i<q.size();i++){
            System.out.print(q.peek()+" ");
            q.add(q.poll());
        }
        System.out.println();
    }
    public static void main(String[] args) {
        InterleaveFirstHalfOfQueueWithSecondHalf q=new InterleaveFirstHalfOfQueueWithSecondHalf();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Queue(Even size only>0)");
        int size=sc.nextInt();
        Queue<Integer>queue=new LinkedList<>();
        for(int i=1;i<=size;i++){
            queue.add(i);
        }
        q.display(queue);
        q.interleave(queue);
        q.display(queue);

    }
}
