import java.util.*;
public class PredAndSucc {

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

    public int predessior(Node root, int node){
        if(root==null){
            return -1;
        }
        int pred=-1;
        Node temp=root;
        while(temp.data!=node){
            
            if(node>temp.data){
                pred=temp.data;
                temp=temp.right;
            }
            else{
                temp=temp.left;
            }
        }
        Node leftSubTree=temp.left;
        while(leftSubTree!=null){
            pred=leftSubTree.data;
            leftSubTree=leftSubTree.right;
        }
        return pred;
    }

    public void predessesor(Node root,Node node,List<Integer>list){
        if(node==null){
            return;
        }
        predessesor(root,node.left, list);
        list.add(predessior(root, node.data));
        predessesor(root,node.right, list);
    }

    public int findSuccessor(Node root, int node){
        if(root==null){
            return -1;
        }
        Node curr=root;
        int succ=-1;
        while(curr.data!=node){
            if(curr.data>node){
                succ=curr.data;
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        Node rightSubTree=curr.right;
        while(rightSubTree!=null){
            succ=rightSubTree.data;
            rightSubTree=rightSubTree.left;
        }
        return succ;
    }


    public void successor(Node root,Node node,List<Integer>list){
        if(node==null){
            return;
        }
        successor(root, node.left, list);
        list.add(findSuccessor(root,node.data));
        successor(root,node.right,list);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PredAndSucc bst=new PredAndSucc();
        Node root=null;
        System.out.println("Enter data into bst to stop enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            root=bst.buildBST(root, data);
            data=sc.nextInt();
        }
        System.out.println("InOrderTraversal of BST is ");
        bst.InOrderTraversal(root);

        

        // System.out.println("Enter the node data to find its predessesor");
        // int node=sc.nextInt();
        // bst.predessior(root,node);
        List<Integer>predessesorList=new ArrayList<>();
        bst.predessesor(root,root, predessesorList);
        System.out.println("\nPredessessor of each node is as below");
        for(int i=0;i<predessesorList.size();i++){
            System.out.print(predessesorList.get(i)+" ");
        }
        List<Integer>successorList=new ArrayList<>();
        bst.successor(root,root, successorList);
        System.out.println("\nSuccessor of each node is as below");
        for(int i=0;i<successorList.size();i++){
            System.out.print(successorList.get(i)+" ");
        }




        

    }

}
