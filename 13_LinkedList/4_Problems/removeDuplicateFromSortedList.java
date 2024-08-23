import java.util.*;
public class removeDuplicateFromSortedList {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public void add(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void removeDuplicate(){
        if(head==null || head.next==null){
            display();
            return;
        }
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }
        display();
    }
    public static void main(String args[]){
        removeDuplicateFromSortedList list=new removeDuplicateFromSortedList();
        System.out.println("Enter 0 to stop \n Else enter numbers in non-increasing order");
        Scanner sc=new Scanner(System.in);
        int n;
        do{
            n=sc.nextInt();
            if(n>0){
                list.add(n);
            }
        }
        while(n>0);
        list.display();
        list.removeDuplicate();
    }
}
