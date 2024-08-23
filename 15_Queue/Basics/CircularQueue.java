import java.util.Scanner;

public class CircularQueue {
    int[] arr;
    int front;
    int rear;
    CircularQueue(int size){
        arr=new int[size];
        front=-1;
        rear=-1;
    }

    public boolean isFull(){
        if((front==0 && rear==arr.length-1) || (rear==(front-1)%(arr.length-1))){
            return true;
        }
        return false;
    }



    public void push(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(front==-1){
            front++;
            rear++;
            arr[rear]=data;
            display();
            return;
        }
        if(rear==arr.length-1 && front!=0){
            rear=0;
            arr[rear]=data;
            display();
            return;
        }
        rear++;
        arr[rear]=data;
        display();
        return;
    }

    public int pop(){
        if(front==-1 && rear==-1){
            return -1;
        }
        if(front==rear){
            int data=arr[front];
            arr[front]=0;
            front=-1;
            rear=-1;
            display();
            return data;
        }
        if(front==arr.length-1){
            int data=arr[front];
            arr[front]=0;
            front=0;
            display();
            return data;
        }
        int data=arr[front];
        arr[front]=0;
        front++;
        display();

        return data;
    }

    public boolean isEmpty(){
        if(front==-1 && rear==-1){
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
        return arr[rear];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("----------------------");
        System.out.println("Queue is ");
        if(front<=rear){
            for(int i=front;i<=rear;i++){
                System.out.print(arr[i]+" ");
            }
            
        }
        else{
            for(int i=front;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            for(int i=0;i<=rear;i++){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
        
        System.out.println("----------------------");
    }

     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of queue");
        int size=sc.nextInt();
        CircularQueue queue=new CircularQueue(size);

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
