import java.util.*;

public class mergeSortInLL {
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

    public void display(Node head){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    private Node findMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    private Node merge(Node left,Node right){
        Node ans=new Node(-1);
        Node temp=ans;
        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.next=left;
                temp=left;
                left=left.next;
            }
            else{
                temp.next=right;
                temp=right;
                right=right.next;
            }
        }
        while(left!=null){
            temp.next=left;
            temp=left;
            left=left.next;
        }
        while(right!=null){
            temp.next=right;
            temp=right;
            right=right.next;
        }
        ans=ans.next;
        // display(ans);
        return ans;
    }

    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=findMid(head);
        Node temp=mid.next;
        mid.next=null;
        Node left=mergeSort(head);
        Node right=mergeSort(temp);
        

        return merge(left,right);

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        mergeSortInLL ll=new mergeSortInLL();
        int data;
        System.out.println("Enter data into LL to stop enter -1");
        do{
            data=sc.nextInt();
            if(data==-1){
                break;
            }
            ll.add(data);
        }
        while(data!=-1);
        ll.display(ll.head);
        Node ans=ll.mergeSort(ll.head);
        ll.display(ans);

    }
}
