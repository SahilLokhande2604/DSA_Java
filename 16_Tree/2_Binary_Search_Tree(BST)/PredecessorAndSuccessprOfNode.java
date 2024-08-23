import java.util.*;

public class PredecessorAndSuccessprOfNode {

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

    class Pair{
        int pred,succ;
        Pair(int pred,int succ){
            this.pred=pred;
            this.succ=succ;
        }
    }
    public Pair findPredecessorAndSuccessor(Node root, int node){
        if(root==null){
            return new Pair(-1,-1);
        }
        Node curr=root;
        int pred=-1;
        int succ=-1;
        while(curr.data!=node){
            if(curr.data>node){
                succ=curr.data;
                curr=curr.left;
            }
            else{
                pred=curr.data;
                curr=curr.right;
            }
            if(curr==null){
                System.out.println("Node does not exist in tree");
                return new Pair(-1,-1);
            }
        }
        Node leftSubTree=curr.left;
        Node rightSubTree=curr.right;
        while(leftSubTree!=null){
            pred=leftSubTree.data;
            leftSubTree=leftSubTree.right;
        }
        while(rightSubTree!=null){
            succ=rightSubTree.data;
            rightSubTree=rightSubTree.left;
        }

        return new Pair(pred,succ);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PredecessorAndSuccessprOfNode bst=new PredecessorAndSuccessprOfNode();
        Node root=null;
        System.out.println("Enter data into bst to stop enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            root=bst.buildBST(root, data);
            data=sc.nextInt();
        }
        System.out.println("InOrderTraversal of BST is ");
        bst.InOrderTraversal(root);

        System.out.println("Enter the node data to find its predecessor and successor in bst");
        int node=sc.nextInt();
        Pair ans=bst.findPredecessorAndSuccessor(root,node);
        System.out.println("Predecessor of "+node+"= "+ans.pred);
        System.out.println("Successor of "+node+"= "+ans.succ);


    }

}
