import java.util.*;

public class LCAinBST {
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

    public Node LCA(Node root,int node1, int node2){
        if(root==null){
            return root;
        }

        if(node1<root.data && node2<root.data){
            return LCA(root.left,node1,node2);
        }
        else if(node1>=root.data && node2>=root.data){
            return LCA(root.right,node1,node2);
        }
        else{
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LCAinBST bst=new LCAinBST();
        Node root=null;
        System.out.println("Enter data into bst to stop enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            root=bst.buildBST(root, data);
            data=sc.nextInt();
        }
        System.out.println("InOrderTraversal of BST is ");
        bst.InOrderTraversal(root);

        System.out.println("Enter the values of nodes to find its LCA");
        int node1=sc.nextInt();
        int node2=sc.nextInt();

        Node ansNode=bst.LCA(root, node1, node2);
        int ans= ansNode==null ? -1 : ansNode.data;
        System.out.println("LCA of "+node1+" ans "+node2 +" is "+ ans);
        
    }
}
