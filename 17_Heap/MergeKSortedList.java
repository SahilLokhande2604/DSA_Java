import java.util.*;
public class MergeKSortedList {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public Node createLL(Scanner sc){
        Node head=null;
        Node tail=head;
        System.out.println("Enter data into SLL to add null enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            if(head==null){
                head=new Node(data);
                tail=head;
            }
            else{
                tail.next=new Node(data);
                tail=tail.next;
            }
            data=sc.nextInt();
        }
        return head;
    }
    public void display(Node head){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("\n");
    }

    Comparator<Node> comparator=new Comparator<Node>(){
        public int compare(Node node1, Node node2){
            return Integer.compare(node1.data,node2.data);
        }
    };

    public Node mergeKSortedLinkedList(Node[] KSortedList){
        PriorityQueue<Node>pq=new PriorityQueue<>(comparator);
        int k=KSortedList.length;
        Node head=null;
        Node tail=null;

        // Step 1: Add head of each list into pq

        for(int i=0;i<k;i++){
            if(KSortedList[i]!=null){
                pq.add(KSortedList[i]);
            }
            
        }

        // Step 2: remove top node from pq and add into ansList and add its next node int pq if present

        // Step 3: Repeat Step 2 till pq is not empty

        while(!pq.isEmpty()){
            Node top=pq.remove();

            if(head==null){
                head=top;
                tail=top;

                if(tail.next!=null){
                    pq.add(tail.next);
                }
            }
            else{
                tail.next=top;
                tail=tail.next;

                if(tail.next!=null){
                    pq.add(tail.next);
                }
            }
        }

        return head;
    }


    public static void main(String[] args) {
        MergeKSortedList mksl=new MergeKSortedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of k");
        int k=sc.nextInt();

        Node[] KSortedList=new Node[k];

        for(int i=0;i<k;i++){
            KSortedList[i]=mksl.createLL(sc);
        }

        for(int i=0;i<k;i++){
            mksl.display(KSortedList[i]);
        }
        System.out.println();


        Node head=mksl.mergeKSortedLinkedList(KSortedList);

        System.out.println("Merged list is ");
        mksl.display(head);
    }
}
