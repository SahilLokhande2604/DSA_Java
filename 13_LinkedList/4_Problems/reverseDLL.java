public class reverseDLL {
    Node head;
    class Node{
        int data;
        Node pre,next;
        Node(int data){
            this.data=data;
            this.pre=null;
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
        newnode.pre=temp;
    }

    public void display(){
        System.out.println("Display using next pointer");
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null\n");
    }

    public void reverse(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
    
        Node pre=null;
        Node curr=head;
        while(curr!=null){
            Node forward=curr.next;
            curr.next=curr.pre;
            curr.pre=forward;
            pre=curr;
            curr=forward;
        }
        head=pre;
        System.out.println("The reverse is");
        display();
        displayReverse();
    }

    public void displayReverse(){
        System.out.println("Display reverse using pre pointer");
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.pre;
        }
        System.out.println("null\n");
    }

    public void recursiveReverse(){
        Node pre=null;
        Node curr=head;
        recursive(pre,curr);
    }

    public void recursive(Node pre,Node curr){
        if(curr==null){
            head=pre;
            System.out.println("The reverse using recursive function is ");
            display();
            displayReverse();
            return;
        }
        Node forward=curr.next;
        curr.next=curr.pre;
        curr.pre=forward;
        recursive(curr, forward);
    }
    public static void main(String args[]){
        reverseDLL dll =new reverseDLL();
        for(int i=1;i<=5;i++){
            dll.add(i);
        }
        dll.display();
        dll.displayReverse();
        dll.reverse();
        dll.recursiveReverse();
    }
}
