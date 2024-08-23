import java.util.*;
public class removeDuplicateFromUnsortedList {
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

    public void removeDuplicateBruteForce(){
        if(head==null || head.next==null){
            display();
            return;
        }
        Node temp=head;
        while(temp!=null){
            Node pre=temp,curr=temp.next;
            while(curr!=null){
                if(curr.data==temp.data){
                    pre.next=curr.next;
                    curr=curr.next;
                    // display();
                }
                else{
                    pre=curr;
                    curr=curr.next;
                }
            }
            temp=temp.next;
        }
        display(); 
    }

    public void removeDuplicateOptimize(){
        if(head==null || head.next==null){
            display();
            return;
        }
        Node curr=head,pre=null;
        HashMap<Integer,Boolean>map=new HashMap<>();
        while(curr!=null){
            if(map.containsKey(curr.data)){
                pre.next=curr.next;
                curr=curr.next;
            }
            else{
                map.put(curr.data,true);
                pre=curr;
                curr=curr.next;
            }
        }
        display();
    }
    public static void main(String args[]){
        removeDuplicateFromUnsortedList list=new removeDuplicateFromUnsortedList();
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
        // list.removeDuplicateBruteForce();
        list.removeDuplicateOptimize();
        
    }
}

