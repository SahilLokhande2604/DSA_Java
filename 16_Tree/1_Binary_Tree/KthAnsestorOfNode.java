import java.util.*;
public class KthAnsestorOfNode {
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

    private Node fastKthAnsestor(Node root,int node,int[] k){
        if(root==null){
            return null;
        }
        if(root.data==node){
            return root;
        }
        Node left=fastKthAnsestor(root.left, node, k);
        Node right=fastKthAnsestor(root.right, node, k);
        if(left!=null && right==null){
            k[0]--;
            if(k[0]==0){
                return root;
            }
            return left;
        }
        if(left==null && right!=null){
            k[0]--;
            if(k[0]==0){
                return root;
            }
            return right;
        }
        return null;
        
    }

    public int KthAnsestor(Node root,int node,int k){
        int[] K={k};
        Node ans=fastKthAnsestor(root, node, K);
        if(ans==null || ans.data==node){
            return -1;
        }
        return ans.data;
    }

    
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        KthAnsestorOfNode kan = new KthAnsestorOfNode();
        Node root = null;
        root = kan.BuildTree(root);
        System.out.println("Level Order Traversal of tree is");
        kan.LevelOrderTraversal(root);
        System.out.println("Enter the value of node to find its ansestor");
        int val=sc.nextInt();
        System.out.println("Enter the value of k");
        int k=sc.nextInt();
        System.out.println("Kth ansestor of node "+val+" is:"+kan.KthAnsestor(root, val, k));
        
    }
}

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1

// 1 2 4 -1 3 8 11 5 -1 9 10 -1 12 6 -1 -1 -1 -1 -1 13 -1 -1 7 15 16 -1 14 -1 -1 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 10 -1 11 -1 -1 -1 -1 -1

// 8 3 10 1 -1 6 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1 

// 1 2 3 6 -1 4 5 -1 8 -1 -1 21 -1 -1 -1 -1 -1 


// 1 2 3 4 2 -1 -1 1 -1 -1 -1 -1 -1 