import java.util.*;
public class stackUsingLL{
    Node head;
    int size=0;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void push(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            size++;
            return;
        }
        newnode.next=head;
        head=newnode;
        size++;
    }
    public int pop(){
        if(head==null){
            return -1;
        }
        int data=head.data;
        head=head.next;
        size--;
        return data;
    }
    public int peek(){
        if(head==null){
            return -1;
        }
        return head.data;
    }
    public int size(){
        if(head==null){
            return 0;
        }
        return size;
    }
    public void display(){
        if(head==null){
            System.out.println("Stack is empty");
            return;
        }
        Node temp=head;
        System.out.println("---------");
        while(temp!=null){
            System.out.println("|  "+temp.data+"  |");
            temp=temp.next;
        }
        System.out.println("-------- ");

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        stackUsingLL stack=new stackUsingLL();
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