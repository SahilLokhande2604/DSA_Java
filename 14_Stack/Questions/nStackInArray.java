import java.util.*;
public class nStackInArray {

    public class NStack{
        int[] arr;
        int[] top;
        int[] next;
        int freeSpot;

        NStack(int size,int n){
            arr=new int[size];
            top=new int[n];
            next=new int[size];
            freeSpot=0;
            for(int i=0;i<n;i++){
                top[i]=-1;
            }
            for(int i=0;i<size;i++){
                next[i]=i+1;
            }
            next[size-1]=-1;
        }
        public boolean push(int data,int stackNo){
            if(freeSpot==-1){
                return false;
            }
            // step 1: find freeSpot 
            int index=freeSpot;
            freeSpot=next[index];
            // step 2: insert element
            arr[index]=data;
            // update the next 
            next[index]=top[stackNo-1];
            // update top
            top[stackNo-1]=index;

            return true;
        }

        public int pop(int stackNo){
            if(top[stackNo-1]==-1){
                return -1;
            }
            int index=top[stackNo-1];
            top[stackNo-1]=next[index];
            next[index]=freeSpot;
            freeSpot=index;

            return arr[index];
        }
    }

    

    public void display(int[] arr){
        System.out.println("Array is ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size=sc.nextInt();
        System.out.println("Enter the no. of stacks to implement in array");
        int n=sc.nextInt();
        nStackInArray nStack=new nStackInArray();
        NStack stack=nStack.new NStack(size, n);
        boolean iterator=true;
        while(iterator){
            System.out.println("To push in an array enter 1,to pop enter 2 to exit enter 0");
            int key=sc.nextInt();
            switch(key){
                case 1: 
                    System.out.println("Enter the stack no.");
                    int stackNo=sc.nextInt();
                    System.out.println("Enter the data to be push in "+stackNo+" stack");
                    int data=sc.nextInt();
                    boolean flag=stack.push(data, stackNo);
                    if(flag==true){
                        System.out.println("data added successfully in "+stackNo+" stack");
                    }
                    else{
                        System.out.println("Stack overflow");
                    }
                    break;
                    
                case 2:
                    System.out.println("Enter the stack no.");
                    stackNo=sc.nextInt();
                    int ans=stack.pop(stackNo);
                    if(ans==-1){
                        System.out.println("Stack is empty");
                    }
                    else{
                        System.out.println("Data "+ans+" pop successfully from "+stackNo+" stack");
                    }
                    break;
                
                case 0:
                    iterator=false;
                    break;
                default:
                    System.out.println("Please enter valid key");
                    break;
                    
            }
        }
        
    }   
}
