import java.util.*;
public class stackUsingArray{
    int[] stack=new int[100];
    int index=-1;
    int size=0;
    public void push(int data){
        if(index>=100){
            System.out.println("Stack is full");
            return;
        }
        stack[++index]=data;
        size++;
    }

    public int pop(){
        if(index==-1){
            System.out.println("Stack is empty");
            return -1;
        }
        int data=stack[index];
        stack[index--]=0;
        size--;
        return data;
        
    }

    public int size(){
        return size;
    }

    public void display(){
        if(index==-1){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("---------");
        for(int i=index;i>=0;i--){
            System.out.println("|  "+stack[i]+"  |");
        }
        System.out.println("---------");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        stackUsingArray stack=new stackUsingArray();
        boolean flag=true;
        do{
            System.out.println("To push enter 1\nTo pop enter 2\nTo display enter 3\nTo get size enter 4\nTo exit enter 0\n");
            int n=sc.nextInt();
            switch(n){
                case 1:
                System.out.println("Enter data to push in stack");
                int data=sc.nextInt();
                stack.push(data);
                break;

                case 2:
                int popData=stack.pop();
                if(popData==-1){
                    System.out.println("Stack is empty");
                    break;
                }
                System.out.println("Data "+popData+" popped successfully");
                break;

                case 3:
                stack.display();
                break;

                case 4:
                System.out.println("Size="+stack.size());
                break;

                case 0:
                flag=false;
                break;

                default:
                System.out.println("Please enter valid key");
                break;
            }
        }
        while(flag);

    }
}