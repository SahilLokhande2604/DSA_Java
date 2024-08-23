public class operations{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public void addFirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
        display();
    }

    public void addlast(int data){
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
        display();
    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("List is already empty");
            return;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        display();
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("he list is already empty");
            return;
        }
        Node pre=null;
        Node curr=head;
        while(curr.next!=null){
            pre=curr;
            curr=curr.next;
        }
        pre.next=null;
        display();
        
    }

    public void deleteAny(int index){
        if(head==null){
            System.out.println("The list is already empty");
            return;
        }
        if(index==1){
            deleteFirst();
            return;
        }
        Node pre=null;
        Node curr=head;
        while(curr.next!=null && index>1){
            pre=curr;
            curr=curr.next;
            index--;
        }
        if(index>1 || index<1){
            System.out.println("Please enter valid index");
            return;
        }
        pre.next=curr.next;
        curr.next=null;
        display();
    }

    public boolean search(int data){
        Node temp=head;
        while(temp!=null){
            if(temp.data==data){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public void display(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        operations list=new operations();
        list.addFirst(2);
        list.addFirst(1);
        list.addlast(10);
        list.addFirst(0);
        list.addlast(11);
        System.out.println("data 100 is present? "+list.search(100));
        System.out.println("data 10 is present? "+list.search(10));
        list.deleteFirst();
        list.deleteLast();
        list.addlast(100);
        list.deleteAny(2);
        list.deleteAny(5);
        list.deleteAny(1);
        list.deleteAny(2);
        System.out.println("data 100 is present? "+list.search(100));
        list.deleteAny(0);
        list.deleteAny(1);
        list.deleteAny(1);


    }
}