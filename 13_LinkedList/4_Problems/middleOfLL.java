public class middleOfLL {
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

    public void middle(){
        if(head==null){
            System.out.println("null");
            return;
        }
        if(head.next==null){
            System.out.println(head.data);
            return;
        }
        Node slow=head;
        Node fast=head.next;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
            slow=slow.next;
        }
        System.out.println(slow.data);
    }


   public static void main(String args[]){
    middleOfLL list=new middleOfLL();
        for(int i=1;i<=11;i++){
            list.add(i);
        }
        list.display();
        System.out.println("Middle of LL is ");
        list.middle();
   } 
}
