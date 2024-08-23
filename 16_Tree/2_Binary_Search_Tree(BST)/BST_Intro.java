import java.util.*;
public class BST_Intro{
    Scanner sc=new Scanner(System.in);
    class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public Node buildBST(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data<root.data){
            root.left=buildBST(root.left, data);
        }
        if(data>root.data){
            root.right=buildBST(root.right, data);
        }
        return root;
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
        Scanner sc=new Scanner(System.in);
        BST_Intro bst=new BST_Intro();
        Node root=null;
        System.out.println("Enter data into bst to stop enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            root=bst.buildBST(root, data);
            data=sc.nextInt();
        }
        System.out.println("InOrderTraversal of BST is ");
        bst.InOrderTraversal(root);
        

    }
}