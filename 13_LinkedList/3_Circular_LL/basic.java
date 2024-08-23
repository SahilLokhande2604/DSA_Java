import java.util.*;

public class basic {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = this;
        }
    }

    public void addFirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            display();
            return;
        }
        newnode.next = head;
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newnode;
        head = newnode;
        display();
    }

    public void addLast(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            display();
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.next = head;
        display();
    }

    public void addAtIndex(int data, int index) {
        Node newnode = new Node(data);
        if (head == null) {
            if (index != 0) {
                System.out.println("List is empty so please enter index 0 to add data");
                return;
            }
            head = newnode;
            display();
            return;
        }
        Node temp = head;
        int count = 0;
        while (count < index - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        if (count < index - 1 && temp.next == head) {
            System.out.println("The length of circular LL is " + (count + 1) + " and the index provided by you is "
                    + index + " > " + (count + 1));
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (temp.next == head) {
            addLast(data);
            return;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        display();
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is already empty\n");
            return;
        }
        Node temp = head;
        if (head.next == head) {
            head = null;
            display();
            return;
        }
        while (temp.next != head) {
            temp = temp.next;
        }
        head = head.next;
        temp.next = head;
        display();

    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is already empty\n");
            return;
        }
        Node curr = head;
        Node pre = head;
        if (head.next == head) {
            head = null;
            display();
            return;
        }
        while (curr.next != head) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = head;
        display();

    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            System.out.println("List is already empty\n");
            return;
        }
        Node pre = head;
        Node curr = head;
        int count = 0;

        while (count < index && curr.next != head) {
            pre = curr;
            curr = curr.next;
            count++;
        }
        if (count < index && curr.next == head) {
            System.out.println("The lenght of circular linked list is " + (count + 1) + " but index enter by you is "
                    + index + " > length ");
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        } else if (curr.next == head) {
            deleteLast();
            return;
        } else {
            pre.next = curr.next;
            display();
        }
    }

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("null\n");
            return;
        }
        while (temp.next != head) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data + " ->");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        basic cll = new basic();
        boolean flag = true;
        do {
            System.out.println(
                    " Enter 1 to add at first\n Enter 2 to add at last\n Enter 3 to add at any index(0 indexed LL)\n Enter 4 to display\n Enter 5 to delete node\n Enter 0 to stop");
            int key = sc.nextInt();

            switch (key) {
                case 0:
                    flag = false;
                    break;

                case 1:
                    System.out.println("Enter data to add at first");
                    int data = sc.nextInt();
                    cll.addFirst(data);
                    break;
                case 2:
                    System.out.println("Enter data to add at last");
                    data = sc.nextInt();
                    cll.addLast(data);
                    break;
                case 3:
                    System.out.println("Enter data to add at any index (0 indexed LL)\nEnter data:");
                    data = sc.nextInt();
                    System.out.println("Enter index (0 indexed LL):");
                    int index = sc.nextInt();
                    cll.addAtIndex(data, index);
                    break;
                case 4:
                    System.out.println("Circular LinkedList is ");
                    cll.display();
                    break;
                case 5:
                    System.out.println("Enter index (0 indexed LL) to delete the node");
                    index = sc.nextInt();
                    cll.deleteAtIndex(index);
                    break;
                default:
                    System.out.println("Please enter valid key");
                    break;

            }
        } while (flag);

    }
}