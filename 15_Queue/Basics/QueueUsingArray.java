import java.util.*;
public class QueueUsingArray{
    int[] arr;
    int front;
    int rear;

    QueueUsingArray(int size){
        arr=new int[size];
        front=0;
        rear=0;
    }

    public void push(int data){
        
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        arr[rear]=data;
        rear++;
        display();
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int data=arr[front];
        arr[front]=0;
        front++;
        if(front==rear){
            front=0;
            rear=0;
        }
        display();
        return data;

    }

    public boolean isEmpty(){
        if(front==rear){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(rear==arr.length){
            return true;
        }
        return false;
    }

    public int front(){
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }

    public int rear(){
        if(isEmpty()){
            return -1;
        }
        return arr[rear-1];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        for(int i=front;i<rear;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of queue");
        int n=sc.nextInt();
        QueueUsingArray queue=new QueueUsingArray(n);
        boolean flag=true;
        while(flag){
            System.out.println("Enter 1 to push,\n2 to pop,\n3 to get front,\n4 to get rear,\n5 to check is full,\n0 to exit");
            int key=sc.nextInt();
            switch(key){
                case 1:
                    System.out.println("Enter data to push in queue");
                    int data=sc.nextInt();
                    queue.push(data);
                    break;

                case 2:
                    data=queue.pop();
                    System.out.println("Popped data is "+data);
                    break;

                case 3:
                    System.out.println("Element at front of Queue is "+queue.front());
                    break;

                case 4:
                    System.out.println("Element at tail of Queue is "+queue.rear());
                    break;
                
                case 5:
                    if(queue.isFull()){
                        System.out.println("Queue is full");
                    }
                    else{
                        System.err.println("Queue is not full");
                    }
                    break;
                
                case 0:
                    flag=false;
                    break;
                
                default:
                    System.out.println("Please enter valid data");
                    break;
            }
        }
        
    }
}