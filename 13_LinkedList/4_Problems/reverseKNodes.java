import java.util.*;
public class reverseKNodes {
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

    public void reverseKNode(int k){
        if(k==0 || k==1){
            return;
        }
        head=reverse(head,k);
        display();
    }

    public Node reverse(Node head,int k){
        if(head==null){
            return null;
        }
        Node pre=null;
        Node curr=head;
        int count=0;
        while(curr!=null && count<k){
            Node forward=curr.next;
            curr.next=pre;
            pre=curr;
            curr=forward;
            count++;
        }
        head.next=reverse(curr,k);
        return pre;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        reverseKNodes list=new reverseKNodes();
        for(int i=1;i<=10;i++){
            list.add(i);
        }
        list.display();
        System.out.println("Enter the value of 'k' to reverse group of k nodes");
        int k=sc.nextInt();
        list.reverseKNode(k);
        list.display();
    

    }
}
