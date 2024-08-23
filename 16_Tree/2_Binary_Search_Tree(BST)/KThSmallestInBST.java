import java.util.Scanner;

public class KThSmallestInBST {
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

    private int fastSolve(Node root, int k, int[] count){
        if(root==null){
            return -1;
        }
        // Left
        int left=fastSolve(root.left, k, count);

        if(left!=-1){
            return left;
        }
        // root
        count[0]++;
        if(count[0]==k){
            return root.data;
        }
        // right
        return fastSolve(root.right, k, count);

    }

    // for kth largest element use if n-k+1==count
    public int KthSmallestElement(Node root, int k){
        if(root==null){
            return -1;
        }
        int[] count={0};
        return fastSolve(root,k,count);
    }

    private Node predecessor(Node root){
        if(root==null){
            return null;
        }
        Node curr=root.left;
        while(curr.right!=null && curr.right!=root){
            curr=curr.right;
        }
        return curr;
    }

    public void morisTraversal(Node root){
        if(root==null){
            return;
        }
        Node curr=root;
        while(curr!=null){

            if(curr.left==null){
                System.out.print(curr.data+"->");
                curr=curr.right;
            }
            else{
                Node pred=predecessor(curr);
                if(pred.right!=null){
                    System.out.print(curr.data+"->");
                    pred.right=null;
                    curr=curr.right;
                }
                else{
                    pred.right=curr;
                    curr=curr.left;
                }
                
                
            }
            
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data into bst");
        KThSmallestInBST bst=new KThSmallestInBST();
        Node root=null;

        System.out.println("Enter the data to stop enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            root=bst.buildBST(root,data);
            data=sc.nextInt();
        }

        System.out.println("Its Inorder Traversal is");
        bst.InOrderTraversal(root);

        System.out.println("Enter the value of k to find Kth smallest element");
        int k=sc.nextInt();
        System.out.println("Kth smallest eleemnt is "+bst.KthSmallestElement(root,k));
        
        bst.morisTraversal(root);

    }
}
