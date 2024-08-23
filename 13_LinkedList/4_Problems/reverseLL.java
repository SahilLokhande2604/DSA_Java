public class reverseLL{
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

    public void reverse(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node pre=null;
        Node curr=head;
        while(curr!=null){
            Node forward=curr.next;
            curr.next=pre;
            pre=curr;
            curr=forward;
        }
        head=pre;
        display();
    }

    public void recursiveReverse(Node pre,Node curr){
        if(curr==null){
            head=pre;
            display();
            return;
        }
        Node forward=curr.next;
        curr.next=pre;
        recursiveReverse(curr, forward);
    }
    public void recursive(){
        Node pre=null;
        Node curr=head;
        recursiveReverse(pre,curr);
    }


    public static void main(String args[]){
        reverseLL list=new reverseLL();
        for(int i=1;i<=5;i++){
            list.add(i);
        }
        list.display();
        list.reverse();
        list.recursive();
    }
}