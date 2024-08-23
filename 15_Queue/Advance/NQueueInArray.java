import java.util.*;
public class NQueueInArray {
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int freeSpot;
    NQueueInArray(int size,int n){
        arr=new int[size];
        front=new int[n];
        rear=new int[n];
        next=new int[size];
        freeSpot=0;
        for(int i=0;i<n;i++){
            front[i]=-1;
            rear[i]=-1;
        }
        for(int i=0;i<size;i++){
            next[i]=i+1;
        }
        if(size>0){
            next[size-1]=-1;
    }
        }
        

    public void push(int data,int k){
        k--;
        if(freeSpot==-1){
            System.out.println("array is full");
            return ;
        }
        int index=freeSpot;
        freeSpot=next[index];

        if(front[k]==-1){
            front[k]=index;
        }
        else{
            next[rear[k]]=index;
        }
        next[index]=-1;
        rear[k]=index;
        arr[index]=data;
    }

    public int pop(int k){
        k--;
        if(front[k]==-1){
            System.out.println("Queue is Empty");
            return -1;
        }
        int index=front[k];
        front[k]=next[index];
        next[index]=freeSpot;
        freeSpot=index;
        int data=arr[index];
        arr[index]=0;

        return data;
    }

    public int peek(int k){
        k--;
        if(front[k]==-1){
            System.out.println("Queue is Empty");
            return -1;
        }
        return front[k];
    }

    public void display(){
        System.out.println("Array is ");
        for(int i=0;i<arr.length;i++){
            System.err.print(arr[i]+" ");
        }
        System.out.println();
    }                                                                                             

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size=sc.nextInt();
        
        // int[] arr=new int[size];
        System.out.println("Enter the no. of queue you want to implement in an array");
        int n=sc.nextInt();

        NQueueInArray q=new NQueueInArray(size,n);

        boolean flag=true;
        while(flag){
            System.out.println("Enter 1 to push\nEnter 2 to pop\nEnter 3 to get peek\nEnter 0 to exit");
            int key=sc.nextInt();
            switch (key) {
                case 1:
                    System.out.println("Enter the queue no. ");
                    int qNo=sc.nextInt();
                    if(qNo>n){
                        System.out.println("Please enter queue no. less than "+n+" and greater than 0");
                        break;
                    }
                    System.out.println("Enter the data to push in queue "+qNo);
                    int data=sc.nextInt();
                    q.push(data, qNo);

                    q.display();
                    
                    break;

                case 2:
                    System.out.println("Enter the queue no.");
                    qNo=sc.nextInt();
                    if(qNo>n){
                        System.out.println("Please enter queue no. less than "+n+" and greater than 0");
                        break;
                    }
                    data=q.pop(qNo);
                    if(data==-1){
                        System.out.println("Queue is Empty\n");
                    }
                    else{
                        System.out.println(data+" popped successfully from queue "+qNo);
                        q.display();
                    }
                    break;

                case 3:
                    System.out.println("Enter the queue no.");
                    qNo=sc.nextInt();
                    if(qNo>n){
                        System.out.println("Please enter queue no. less than "+n+" and greater than 0");
                        break;
                    }
                    System.err.println("Peek of queue "+qNo+"= "+ q.peek(qNo));
                    q.display();
                    break;

                case 0:
                    flag=false;
                    break;
            
                default:
                    System.out.println("Please enter valid key");
                    break;
            }
        }

    }
}
