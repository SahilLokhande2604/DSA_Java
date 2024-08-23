import java.util.*;

public class BinaryTreeFromInOrderAndPreOrderTraversal {
    
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
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
    private int findInInorder(int[] inorder,int element){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==element){
                return i;
            }
        }
        return -1;
    }
    private Node build(int[] inorder, int[] preorder, int inStart, int inEnd , int[] currIndex){
        if(currIndex[0]>=inorder.length || inStart>inEnd){
            return null;
        }
        int element=preorder[currIndex[0]++];
        int index=findInInorder(inorder, element);
        Node root=new Node(element);
        root.left=build(inorder, preorder, inStart, index-1, currIndex);
        root.right=build(inorder, preorder, index+1, inEnd, currIndex);

        return root;
    }


    public Node buildTreeFromInOrderAndPreOrderTraversal(int[] inorder, int[] preorder){
        int[] currIndex={0};
        return build(inorder, preorder, 0, preorder.length-1, currIndex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeFromInOrderAndPreOrderTraversal bt=new BinaryTreeFromInOrderAndPreOrderTraversal();
        System.out.println("Enter the no. of nodes of tree");
        int n=sc.nextInt();
        System.out.println("Enter the In Order Traversal of Tree");
        int[] inorder=new int[n];
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }

        System.out.println("Enter the Pre Order Traversal of Tree");
        int[] preorder=new int[n];
        for(int i=0;i<n;i++){
            preorder[i]=sc.nextInt();
        }
        Node root=bt.buildTreeFromInOrderAndPreOrderTraversal(inorder,preorder);
        bt.LevelOrderTraversal(root);

    }
}
