import java.util.*;

public class FlattenBinaryTreeToLinkedList {
    Scanner sc = new Scanner(System.in);

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node BuildTree(Node root) {
        System.out.println("Enter data of root node");
        int data = sc.nextInt();
        if (data != -1) {
            root = new Node(data);
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            System.out.println("Enter data to left of node " + curr.data);
            data = sc.nextInt();
            if (data != -1) {
                Node newnode = new Node(data);
                curr.left = newnode;
                q.add(newnode);
            }
            System.out.println("Enter data to right of node " + curr.data);
            data = sc.nextInt();
            if (data != -1) {
                Node newnode = new Node(data);
                curr.right = newnode;
                q.add(newnode);
            }
        }
        return root;
    }

    public void LevelOrderTraversal(Node root) {
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                System.out.println();
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    private Node Predesessor(Node root){
        Node node=root.left;
        while(node.right!=null){
            node=node.right;
        }
        return node;
    }

    public void FlattenBTToLL(Node root){
        Node curr=root;
        while(curr!=null){
            if(curr.left!=null){
                Node pred=Predesessor(curr);
                pred.right=curr.right;
                curr.right=curr.left;
                curr.left=null;    
            }
            curr=curr.right;
        }
    }

    public void InOrderTraversal(Node root){
        
        if(root==null){
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(root.data+" ");
        InOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList fbt=new FlattenBinaryTreeToLinkedList();
        Node root=null;
        root=fbt.BuildTree(root);
        fbt.LevelOrderTraversal(root);
        fbt.FlattenBTToLL(root);
        System.out.println("InOrderTraversal is");
        fbt.InOrderTraversal(root);


    }
}
// 1 2 3 4 5 -1 6 -1 -1 7 8 -1 9 -1 -1 -1 -1 -1 10 -1 -1