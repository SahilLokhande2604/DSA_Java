import java.util.*;

public class BSTfromPreOrder {
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    public void InOrderTraversal(Node root){
        if(root==null){
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(root.data+" ");
        InOrderTraversal(root.right);
    }

    public void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                if(!q.isEmpty()){
                    q.add(null);
                }
                
                System.out.println();
                
            }
            else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        // System.out.println();
    }

    private Node solve(List<Integer>preorder,int mini, int maxi, int[] index){
        if(index[0]>=preorder.size()){
            return null;
        }
        if(preorder.get(index[0])<mini || preorder.get(index[0])>maxi){
            return null;
        }
        Node root=new Node(preorder.get(index[0]));
        index[0]++;
        root.left=solve(preorder, mini, root.data, index);
        root.right=solve(preorder, root.data, maxi, index);

        return root;
    }

    public Node BSTfromPreOrderTraversal(List<Integer>preorder){
        int[] index={0};
        return solve(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE,index);
    }


    public static void main(String[] args) {
        BSTfromPreOrder bst=new BSTfromPreOrder();
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the pre order traversal of a tree to construct BST from it");
        List<Integer>preorder=new ArrayList<>();
        System.out.println("To stop enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            preorder.add(data);
            data=sc.nextInt();
        }
        for(int i=0;i<preorder.size();i++){
            System.out.print(preorder.get(i)+" ");
        }
        System.out.println();
        Node root=bst.BSTfromPreOrderTraversal(preorder);

        bst.levelOrderTraversal(root);
        bst.InOrderTraversal(root);



    }
}
