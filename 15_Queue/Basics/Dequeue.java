import java.util.*;
public class Dequeue {
    int[] arr;
    int front;
    int rear;

    Dequeue(int size){
        arr=new int[size];
        front=-1;
        rear=-1;
    }

    public boolean isFull(){
        if((front==0 && rear==arr.length-1 ) || (rear==(front-1)%(arr.length-1))){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(front==-1){
            return true;
        }
        return false;
    }

    public void pushFront(int data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        if(front==-1){
            front++;
            rear++;
            arr[front]=data;
            return;
        }
        if(front==0 && !isFull()){
            front=arr.length-1;
            arr[front]=data;
            return;
        }
        front--;
        arr[front]=data;

    }

    public void pushBack(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(rear==arr.length-1 && front!=0){
            rear=0;
            arr[rear]=data;
            return;
        }
        if(rear==-1){
            front++;
            rear++;
            arr[rear]=data;
            return;
        }
        rear++;
        arr[rear]=data;
    }

    public int popFront(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        if(front==arr.length-1){
            int data=arr[front];
            arr[front]=0;
            front=0;
            return data;
        }
        if(front==rear){
            int data=arr[front];
            arr[front]=0;
            front=-1;
            rear=-1;
            return data;
        }
        int data=arr[front];
        arr[front]=0;
        front++;
        return data;
    }

    public int popBack(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        if(front==rear){
            int data=arr[rear];
            arr[rear]=0;
            front=-1;
            rear=-1;
            return data;
        }
        if(rear==0){
            int data=arr[rear];
            arr[rear]=0;
            rear=arr.length-1;
            return data;
        }
        int data=arr[rear];
        arr[rear]=0;
        rear--;
        return data;
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
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Queue");
        int size=sc.nextInt();
        Dequeue dequeue=new Dequeue(size);

        boolean flag=true;
        while(flag){
            System.out.println("Enter 1 to pushFront,\n2 to pushBack,\n3 to popFront,\n4 to popBack,\n5 to check is full,\n0 to exit");
            int key=sc.nextInt();
            switch(key){
                case 1:
                    System.out.println("Enter data to push in queue at front");
                    int data=sc.nextInt();
                    dequeue.pushFront(data);
                    dequeue.display();
                    break;

                case 2:
                System.out.println("Enter data to push in queue at back");
                data=sc.nextInt();
                dequeue.pushBack(data);
                dequeue.display();
                break;

                case 3:
                    data=dequeue.popFront();
                    if(data==-1){
                        System.out.println("Queue is Empty");
                        dequeue.display();
                    }
                    else{
                        System.out.println("Popped data from front is "+data);
                        dequeue.display();
                    }
                    
                    break;

                case 4:
                data=dequeue.popBack();
                if(data==-1){
                    System.out.println("Queue is Empty");
                }
                else{
                    System.out.println("Popped data from back is "+data);
                    dequeue.display();
                }
                
                break;
                
                case 5:
                    if(dequeue.isFull()){
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
