import java.util.*;

public class QueueUsingLL {
    int maxSize;
    int size=0;
    Node front;
    Node rear;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    QueueUsingLL(int size){
        this.maxSize=size;
        front=null;
        rear=null;
    }

    public boolean isFull(){
        if(size==maxSize){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        Node newnode=new Node(data);
        if(isEmpty()){
            front=newnode;
            rear=newnode;
            size++;
            display();
            return;
        }
        rear.next=newnode;
        rear=newnode;
        size++;
        display();
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int data=front.data;
        if(front==rear){
            front=null;
            rear=null;
            size--;
            display();
            return data;
        }
        front=front.next;
        size--;
        display();
        return data;
    }

    public int front(){
        if(isEmpty()){
            return -1;
        }
        return front.data;
    }

    public int rear(){
        if(isEmpty()){
            return -1;
        }
        return rear.data;
    }

    public void display(){
        if(front==null ){
            System.out.println("Queue is Empty");
            return;
        }
        Node temp=front;
        while(temp!=rear.next){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of queue");
        int size=sc.nextInt();
        QueueUsingLL queue=new QueueUsingLL(size);

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
