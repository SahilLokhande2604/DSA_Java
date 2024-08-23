import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Bloodline {
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

    class Pair{
        int height;
        int sum;
        Pair(int height,int sum){
            this.height=height;
            this.sum=sum;
        }
    }

    public Pair fastSumOfRootToLeaf(Node root){
        if(root==null){
            Pair p=new Pair(0,0);
            return p;
        }
        if(root.left==null && root.right==null){
            Pair p=new Pair(1,root.data);
            return p;
        }
        Pair leftSubTree=fastSumOfRootToLeaf(root.left);
        Pair rightSubTree=fastSumOfRootToLeaf(root.right);
        int height=Math.max(leftSubTree.height,rightSubTree.height) +1;
        int sum=root.data;
        if(leftSubTree.height==rightSubTree.height){
            sum+=Math.max(leftSubTree.sum,rightSubTree.sum);
        }
        else if(leftSubTree.height>rightSubTree.height){
            sum+=leftSubTree.sum;
        }
        else{
            sum+=rightSubTree.sum;
        }
        Pair p=new Pair(height, sum);
        return p;
        
    }
    

    

    public int sumOfRootToLeaaf(Node root) {
        return fastSumOfRootToLeaf(root).sum;
    }

    

    public static void main(String args[]) {
        Bloodline bl = new Bloodline();
        Node root = null;
        root = bl.BuildTree(root);
        System.out.println("Level Order Traversal of tree is");
        bl.LevelOrderTraversal(root);
        System.out.println("Sum of longest root to leaf path of tree is ");
        System.out.println("Sum of bloodline is: "+bl.sumOfRootToLeaaf(root));

    }
}

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1

// 1 2 4 -1 3 8 11 5 -1 9 10 -1 12 6 -1 -1 -1 -1 -1 13 -1 -1 7 15 16 -1 14 -1 -1 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 10 -1 11 -1 -1 -1 -1 -1

// 8 3 10 1 -1 6 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1 
