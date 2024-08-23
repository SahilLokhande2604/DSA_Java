import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LCA {
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

    

    public Node fastLCA(Node root,Node n1, Node n2){
        if(root==null){
            return null;
        }
        
        if(root.data==n1.data){
            return root;
        }
        if(root.data==n2.data){
            return root;
        }
        if(root.left==null && root.right==null){
            return null;
        }
        Node left=fastLCA(root.left, n1, n2);
        Node right=fastLCA(root.right, n1, n2);
        if(left!=null && right!=null){
            return root;
        }
        else if(left==null && right!=null){
            return right;
        }
        else if(left!=null && right==null){
            return left;
        }
        return null;
    }
    

    

    public int findLCA(Node root,Node n1,Node n2) {
        return fastLCA(root,n1,n2).data;
    }

    

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        LCA lca = new LCA();
        Node root = null;
        root = lca.BuildTree(root);
        System.out.println("Level Order Traversal of tree is");
        lca.LevelOrderTraversal(root);
        System.out.println("Lowest Common Ansestor of n1 and n2 is:");
        System.out.println("Enter the node n1 value");
        int data=sc.nextInt();
        Node n1=lca.new Node(data);
        System.out.println("Enter the node n2 value");
        data=sc.nextInt();
        Node n2=lca.new Node(data);
        System.out.println("Sum of bloodline is: "+lca.findLCA(root,n1,n2));

    }
}

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1

// 1 2 4 -1 3 8 11 5 -1 9 10 -1 12 6 -1 -1 -1 -1 -1 13 -1 -1 7 15 16 -1 14 -1 -1 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 10 -1 11 -1 -1 -1 -1 -1

// 8 3 10 1 -1 6 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1 

// 1 2 3 6 -1 4 5 -1 8 -1 -1 21 -1 -1 -1 -1 -1 