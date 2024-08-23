public class LinkedLists<D>{
    Node head;
    int size=0;
    class Node{
        D data;
        Node next;
        Node(D data){
            this.data=data;
            this.next=null;
        }
    }
    public int size(){
        if(head==null){
            return 0;
        }
        return size;
    }
    public void addFirst(D data){
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

    public void addLast(D data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            size++;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        size++;
    }

    public void add(int index,D data){
        if(head==null && index>0){
            System.out.println("List is empty");
            return;
        }
        Node newnode=new Node(data);
       
        if(index==0){
            addFirst(data);
            return;
        }
        int count=0;
        Node curr=head;
        Node pre=null;
        while(count<index && curr!=null){
            pre=curr;
            curr=curr.next;
            count++;
        }
        if(count<index && curr==null){
            System.out.println("Please enter valid index (0 indexed linkedlist)");
            return;
        }
        newnode.next=curr;
        pre.next=newnode;
        size++;

    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("LinkedList is already empty");
            return;
        }
        System.out.println(head.data+" deleted successfully");
        head=head.next;
        size--;
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("LinkedList is already empty");
            return;
        }
        Node curr=head;
        Node pre=null;
        while(curr.next!=null){
            pre=curr;
            curr=curr.next;
        }
        pre.next=null;
        size--;
        System.out.println(curr.data+" deleted successfully");
    }

    public void delete(int index){
        if(head==null){
            System.out.println("LinkedList is already empty");
            return;
        }
        Node curr=head;
        Node pre=null;
        int count=0;
        if(index==0){
            deleteFirst();
            return;
        }
        if(index<0 || index>=size){
            System.out.println("Please enter valid index (0 indexed LinkedList)");
            return;
        }
        if(index==size-1){
            deleteLast();
            return;
        }

        while(count<index && curr!=null){
            pre=curr;
            curr=curr.next;
            count++;
        }
        if((index<0 || index>size) && curr==null){
            System.out.println("Please enter valid index (0 indexed LinkedList)");
            return;
        }

        pre.next=curr.next;
        System.out.println(curr.data+" deleted successfully");
        size--;
        
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
        
    }
}