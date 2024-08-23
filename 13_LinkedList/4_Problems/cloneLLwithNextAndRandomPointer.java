import java.util.*;
public class cloneLLwithNextAndRandomPointer {
    Node head;
    public class Node{
        int data;
        Node next;
        Node random;
        Node(int data){
            this.data=data;
            this.next=null;
            this.random=null;
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

    public void connectRandomPointer(){
        Scanner sc=new Scanner(System.in);
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.println("Enter data of node to which random pointer of "+temp.data+" is pointing");
            System.out.println("If random pointer for current node is null enter -1");
            int data=sc.nextInt();
            if(data==-1){
                temp=temp.next;
                continue;
            }
            Node temp2=head;
            while(temp2.data!=data && temp2!=null){
                temp2=temp2.next;
            }
            temp.random=temp2;
            temp=temp.next;
        }
    }
    public void dispaly(Node head){
        System.out.println("LL is using next pointer");
        Node temp=head;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");

    }
    public void dispalyWithRandom(Node head){
        System.out.println("LL is using random pointer");
        Node temp=head;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        while(temp!=null){
            if(temp.random==null){
                System.out.println(temp.data+"->null");
            }
            else{
                System.out.println(temp.data+"->"+temp.random.data);
            }
           
            temp=temp.next;
        }
        System.out.println("null");

    }

    public void createCloneUsingNextAndRandom1(){
        System.out.println("Approach# 1");
        System.out.println("TC: O(n2) SC: O(1)");
        Node temp=head;
        Node head2=null;
        Node temp2=head2;
        while(temp!=null){
            Node newnode=new Node(temp.data);
            if(head2==null){
                head2=newnode;
                temp2=head2;
            }
            else{
                temp2.next=newnode;
                temp2=newnode;
            }
            temp=temp.next;
            
        }
        dispaly(head2);
        temp=head;
        temp2=head2;
        while(temp!=null){
            Node temp3=head2;
            while(temp.random!=null && temp3.data!=temp.random.data){
                temp3=temp3.next;
            }
            if(temp.random!=null && temp3.data==temp.random.data){
                temp2.random=temp3;
            }
            temp=temp.next;
            temp2=temp2.next;
        }
        dispalyWithRandom(head2);

    }

    public void createCloneUsingNextAndRandom2(){
        System.out.println("Approach# 2");
        System.out.println("TC: O(n) SC: O(n)");
        Node temp1=head;
        Node head2=null;
        Node temp2=head2;
        while(temp1!=null){
            Node newnode=new Node(temp1.data);
            if(head2==null){
                head2=newnode;
                temp2=head2;
            }
            else{
                temp2.next=newnode;
                temp2=newnode;
            }
            temp1=temp1.next;
        }

        HashMap<Node,Node>map=new HashMap<>();
        temp1=head;
        temp2=head2;
        while(temp1!=null){
            map.put(temp1,temp2);
            temp1=temp1.next;
            temp2=temp2.next;
        }
        temp1=head;
        temp2=head2;
        while(temp2!=null){
            temp2.random=map.get(temp1.random);
            temp1=temp1.next;
            temp2=temp2.next;
        }
        dispaly(head2);
        dispalyWithRandom(head2);


    }

    public void createCloneUsingNextAndRandom3(){
        System.out.println("Approach# 3");
        System.out.println("TC: O(n) SC: O(1)");
        Node originalNode=head;
        Node clonehead=null;
        Node cloneNode=null;

        // Step 1: Create singly LL clone
        while(originalNode!=null){
            Node newnode=new Node(originalNode.data);
            if(clonehead==null){
                clonehead=newnode;
                cloneNode=clonehead;
            }
            else{
                cloneNode.next=newnode;
                cloneNode=newnode;
            }
            originalNode=originalNode.next;
        }

        // Step 2: Mapping of pointers
        originalNode=head;
        cloneNode=clonehead;
        while(originalNode!=null && cloneNode!=null){
            Node next=originalNode.next;
            originalNode.next=cloneNode;
            originalNode=next;
            next=cloneNode.next;
            cloneNode.next=originalNode;
            cloneNode=next;
        }

        // Step 3: Random pointer copy
        originalNode=head;
        cloneNode=clonehead;
        while(originalNode!=null && cloneNode!=null){
            cloneNode.random=originalNode.random.next;
            originalNode=originalNode.next;
            if(originalNode!=null){
                originalNode=originalNode.next;
            }
            cloneNode=cloneNode.next;
            if(cloneNode!=null){
                cloneNode=cloneNode.next;
            }
        }

        // Step 4: Revert step 2
        originalNode=head;
        cloneNode=clonehead;
        while(originalNode!=null && cloneNode!=null){
            // Node next=originalNode.next;
            originalNode.next=cloneNode.next;
            originalNode=cloneNode.next;
            if(originalNode!=null){
                cloneNode.next=originalNode.next;
                cloneNode=originalNode.next;
            }
            
            
        }
        dispaly(clonehead);
        dispalyWithRandom(clonehead);
    }


   public static void main(String args[]){
    cloneLLwithNextAndRandomPointer ll=new cloneLLwithNextAndRandomPointer();
    for(int i=1;i<=5;i++){
        ll.add(i);
    }
    ll.connectRandomPointer();
    ll.dispaly(ll.head);
    ll.dispalyWithRandom(ll.head);
    System.out.println("All approaches are as below");
    ll.createCloneUsingNextAndRandom1();
    ll.createCloneUsingNextAndRandom2();
    ll.createCloneUsingNextAndRandom3();
   }
}
