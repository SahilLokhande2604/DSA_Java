import java.util.*;

public class BSttoBalanceBST {
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
        }
    }

    public Node buildBST(Node root, int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data<root.data){
            root.left= buildBST(root.left, data);
        }
        else{
            root.right= buildBST(root.right, data);
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
        System.out.println();
    }

    private void InOrder(Node root, List<Node>list){
        if(root==null){
            return;
        }
        InOrder(root.left, list);
        list.add(root);
        InOrder(root.right, list);
    }

    

    private Node inOrderToBST(int start, int end, List<Node>list){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(list.get(mid).data);
        root.left=inOrderToBST(start, mid-1, list);
        root.right=inOrderToBST(mid+1, end, list);

        return root;
    }

    public Node buildBalanceBST(Node root){
        if(root==null){
            return null;
        }
        List<Node>list=new ArrayList<>();
        InOrder(root, list);
        return inOrderToBST(0,list.size()-1,list);
    }

    public static void main(String[] args) {
        BSttoBalanceBST bst=new BSttoBalanceBST();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data into BST to stop enter -1");
        int data=sc.nextInt();
        Node root=null;
        while(data!=-1){
            root=bst.buildBST(root, data);
            data=sc.nextInt();
        }

        System.out.println("InOrder Traversal of BST is ");
        bst.InOrderTraversal(root);
        System.out.println();
        System.out.println("Level Order Traversal is");
        bst.levelOrderTraversal(root);

        System.out.println("Balanced BST is");
        root=bst.buildBalanceBST(root);

        System.out.println("Level Order Traversal is");
        bst.levelOrderTraversal(root);


       

    }
}
