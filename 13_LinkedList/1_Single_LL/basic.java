public class basic{

    public static class Node{  //node is created with data and next(address to next node)
        int data;
        Node next;
        Node(int data){    //constructor gets call each time and creates a node with data and points to null(i.e. there is no any next node)
            this.data=data;
            this.next=null;
        }
    }
    public static void main(String args[]){
        Node head=null;                 //head node is use to show the starting of LL
        Node newnode=new Node(11); //new node is created 
        head=newnode;                   //head points to new node
        System.out.println("data="+head.data+", next="+head.next);

    }
}