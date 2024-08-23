import java.util.*;

public class KSumPath {
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

    public void fastKSum(Node root,int k,ArrayList<Integer>path,int[] count){
        if(root==null){
            return;
        }
        path.add(root.data);
        fastKSum(root.left, k, path, count);
        fastKSum(root.right, k, path, count);
        int size=path.size();
        int sum=0;
        for(int i=size-1;i>=0;i--){
            sum=sum+path.get(i);
            if(sum==k){
                count[0]++;
            }
        }
        path.remove(path.size()-1);
    }

    // i.e. find the count of all paths from top to bottom which has sum equal to k the path can start from any node
    public int kSum(Node root,int k){
        if(root==null){
            return 0;
        }
        int[] count=new int[1];
        ArrayList<Integer>path=new ArrayList<>();
        fastKSum(root, k, path, count);
        return count[0];
    }


    

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        KSumPath ksa = new KSumPath();
        Node root = null;
        root = ksa.BuildTree(root);
        System.out.println("Level Order Traversal of tree is");
        ksa.LevelOrderTraversal(root);
        System.out.println("Enter the value of k to find K sum count for all existing paths");
        int k=sc.nextInt();
        System.out.println("The total no. of paths whose sum is equal to k is "+ksa.kSum(root, k));
        

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