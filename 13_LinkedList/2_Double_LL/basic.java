import java.util.*;
public class basic{
    Node head;
    public class Node{
        int data;
        Node pre;
        Node next;

        Node(int data){
            this.data=data;
            this.pre=null;
            this.next=null;
        }
    }

    public void addFirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            display();
            return;
        }
        newnode.next=head;
        head.pre=newnode;
        head=newnode;
        display();
    }

    public void addLast(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            display();
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.pre=temp;
        display();
    }

    public void addAtPosition(int data,int index){
        Node newnode=new Node(data);
        if(head==null){
            if(index!=0){
                System.out.println("Please enter valid index (0 index DLL)\n");
                return;
            }
            head=newnode;
            display();
            return;
        }
        Node temp=head;
        int count=0;
        while(count!=index-1 && temp!=null){
            temp=temp.next;
            count++;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        else if(count!=index-1 || temp==null){
            System.out.println("Please enter valid index (0 indexed LL)\n");
            return;
        }
        else if(temp.next==null){
            addLast(data);
            return;
        }
        else{
            newnode.next=temp.next;
            temp.next.pre=newnode;
            temp.next=newnode;
            newnode.pre=temp;
            display();
        }
    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("List is already empty\n");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        head=head.next;
        head.pre=null;
        display();
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("List is already empty\n");
            return;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.pre.next=null;
        curr.pre=null;
        display();
    }

    public void deleteAtIndex(int index){
        if(head==null){
            System.out.println("List is already empty\n");
            return;
        }
        Node curr=head;
        int count=0;
        while(count!=index && curr!=null){
            curr=curr.next;
            count++;
        }
        if(index==0){
            deleteFirst();
            return;
        }
        else if(count!=index || index<0 || curr==null){ 
            System.out.println("Please enter valid index(0 indexed DLL)\n");
            return;
        }
        else if(curr.next==null){
            deleteLast();
            return;
        }
        
        else{
            curr.pre.next=curr.next;
            curr.next.pre=curr.pre;
            curr.pre=null;
            curr.next=null;
            display();
        }
    }




    public void display(){
        if(head==null){
            System.out.println("List is empty\n");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.next;
        }
        System.out.println("null\n");
    }

    public void displayReverse(){
        if(head==null){
            System.out.println("List is empty\n");
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.pre;
        }
        System.out.println("null\n");
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        basic dll=new basic();
        boolean flag=true;
        do{
            System.out.println(" Enter 1 to add at first\n Enter 2 to add at last\n Enter 3 to add at any index(0 indexed LL)\n Enter 4 to display\n Enter 5 to display reverse\n Enter 6 to delete node\n Enter 0 to stop");
            int key=sc.nextInt();

            switch(key) {
                case 0:
                    flag=false;
                    break;

                case 1:
                    System.out.println("Enter data to add at first");
                    int data=sc.nextInt();
                    dll.addFirst(data);
                    break;
                case 2:
                    System.out.println("Enter data to add at last");
                    data=sc.nextInt();
                    dll.addLast(data);
                    break;
                case 3:
                    System.out.println("Enter data to add at any index (0 indexed LL)\nEnter data:");
                    data=sc.nextInt();
                    System.out.println("Enter index (0 indexed LL):");
                    int index=sc.nextInt();
                    dll.addAtPosition(data,index);
                    break;
                case 4:
                    System.out.println("Doubly LinkedList is ");
                    dll.display();
                    break;
                case 5:
                    System.out.println("Reverse Doubly LinkedList is ");
                    dll.displayReverse();
                    break;
                case 6:
                    System.out.println("Enter index (0 indexed LL) to delete the node");
                    index=sc.nextInt();
                    dll.deleteAtIndex(index);
                    break;
                default:
                    System.out.println("Please enter valid key");
                    break;
                

            }
        }
        while(flag);

    }
}