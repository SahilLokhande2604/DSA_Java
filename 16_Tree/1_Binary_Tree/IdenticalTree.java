import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IdenticalTree {
    Scanner sc=new Scanner(System.in);
    class Node{
        int data;
        Node left,right;

        Node(){

        }

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }


    }
    public Node BuildTree(Node root){
        Queue<Node>queue=new LinkedList<>();
        System.out.println("Enter the data");
        int data=sc.nextInt();
        if(data!=-1){
            root=new Node(data);
            queue.add(root);
        }
        while(!queue.isEmpty()){
            Node curr=queue.remove();
            System.out.println("Enter data to left of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                Node newnode=new Node(data);
                curr.left=newnode;
                queue.add(newnode);
            }

            System.out.println("Enter data to right of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                Node newnode=new Node(data);
                curr.right=newnode;
                queue.add(newnode);
            }
        }
        return root;

    }

    public void LevelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node>queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node curr=queue.remove();
            if(curr==null){
                if(!queue.isEmpty()){
                    System.out.println();
                    queue.add(null);
                }
            }
            else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
        }
    }

    public boolean isIdentical(Node r1, Node r2){
        if(r1==null && r2==null){
            return true;
        }
        if(r1==null && r2!=null){
            return false;
        }
        if(r1!=null && r2==null){
            return false;
        }
        boolean left=isIdentical(r1.left, r2.left);
        boolean right=isIdentical(r1.right, r2.right);
        boolean isValueSame=r1.data == r2.data;

        if(left && right && isValueSame){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IdenticalTree it=new IdenticalTree();
        System.out.println("\nBuild the first tree");
        Node root1=null;
        root1=it.BuildTree(root1);
        System.out.println("\nLevel order traversal is");
        it.LevelOrderTraversal(root1);

        System.out.println("\nBuild the second tree");
        Node root2=null;
        root2=it.BuildTree(root2);
        System.out.println("\nLevel order traversal is");
        it.LevelOrderTraversal(root2);

        System.out.println("\nThe trees are identical? "+it.isIdentical(root1, root2));
    }
}

// 5 3 6 2 4 10 9 -1 -1 -1 -1 -1 -1 5 -1 -1 -1 

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1
