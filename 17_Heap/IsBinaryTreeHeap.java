import java.util.*;
public class IsBinaryTreeHeap {
    class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public Node buildBT(Node root, Scanner sc){
        System.out.println("Enter root data");
        int data=sc.nextInt();
        if(data!=-1){
            root=new Node(data);
        }
        else{
            return null;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.remove();
            System.out.println("Enter left child of "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                curr.left=new Node(data);
                q.add(curr.left);
            }

            System.out.println("Enter right child of "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                curr.right=new Node(data);
                q.add(curr.right);
            }
        }

        return root;
    }

    private int countNodes(Node root){
        if(root==null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public boolean isCBT(Node root, int i, int totalNodes){
        if(root==null){
            return true;
        }
        if(i>=totalNodes){
            return false;
        }
        else{
            boolean left=isCBT(root.left, 2*i + 1 , totalNodes);
            boolean right=isCBT(root.right, 2*i + 2 , totalNodes);

            return left && right;
        }

        
    }

    private boolean isMaxOrder(Node root){
        // leaf nodes
        if(root.left==null && root.right==null){
            return true;
        }
        // left child case
        if(root.right==null){
            return root.left.data<root.data;
        }
        // 2 child case
        return root.left.data<root.data && 
        root.right.data<root.data && 
        isMaxOrder(root.left) && isMaxOrder(root.right);
    }

    public boolean isHeap(Node root){
        if(root==null){
            return true;
        }
        int totalNodes=countNodes(root);

        return isCBT(root,0,totalNodes) && isMaxOrder(root);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data into Binary Tree");
        IsBinaryTreeHeap bt=new IsBinaryTreeHeap();
        Node root=null;
        root=bt.buildBT(root,sc);

        boolean ans=bt.isHeap(root);
        System.out.println("The given binary tree is heap(max.) ");
        System.out.println(ans);
    }
}
