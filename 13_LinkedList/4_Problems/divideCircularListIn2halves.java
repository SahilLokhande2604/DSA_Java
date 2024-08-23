import java.util.*;
public class divideCircularListIn2halves {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=this;
        }
    }

    public void add(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=head;
    }

    public void display(Node head){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
       Node temp=head;
        do{
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        while(temp!=head);
        System.out.println("head");
    }

    public void divideInto2Halves(){
        if(head==null || head.next==head){
            display(head);
            return;
        }
        Node head1=head;
        Node head2;
        Node slow=head;
        Node fast=head.next;
        Node pre=null;
        do{
            fast=fast.next;
            if(fast!=head){
                fast=fast.next;
            }
            pre=slow;
            slow=slow.next;
        }
        while(fast!=head);
        head2=slow;
        pre.next=head1;
        Node temp=head2;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=head2;
        System.out.println("The first halve is ");
        display(head1);
        System.out.println("The second halve is ");
        display(head2);
    }
    public static void main(String args[]){
        divideCircularListIn2halves cll=new divideCircularListIn2halves();
        System.out.println("Enter 0 to stop \n Else enter numbers in non-increasing order");
        Scanner sc=new Scanner(System.in);
        int n;
        do{
            n=sc.nextInt();
            if(n>0){
                cll.add(n);
            }
        }
        while(n>0);
        cll.display(cll.head);
        cll.divideInto2Halves();
    }
}
