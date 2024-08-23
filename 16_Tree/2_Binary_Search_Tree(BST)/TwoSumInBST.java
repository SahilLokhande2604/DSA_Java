// Given a BST and target find whether there exist a pair of numbers whose sum equals to target
import java.util.*;
public class TwoSumInBST {
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

    public Node buildBST(Node root, int data){
        
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data<root.data){
            root.left=buildBST(root.left, data);
        }
        else{
            root.right=buildBST(root.right, data);
        }
        return root;
    }

    public void InOrder(Node root){
        if(root==null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
    }

    public void InOrder(Node root, List<Integer>inorder){
        if(root==null){
            return;
        }
        InOrder(root.left,inorder);
        inorder.add(root.data);
        InOrder(root.right,inorder);
    }

    public boolean TwoSum(Node root, int target){
        List<Integer>inorder=new ArrayList<>();
        InOrder(root,inorder);
        int left=0,right=inorder.size()-1;

        while(left<right){
            int sum=inorder.get(left)+inorder.get(right);

            if(sum==target){
                return true;
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data into bst");
        TwoSumInBST bst=new TwoSumInBST();
        Node root=null;

        System.out.println("Enter the data to stop enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            root=bst.buildBST(root,data);
            data=sc.nextInt();
        }

        System.out.println("Its Inorder Traversal is");
        bst.InOrder(root);

        System.err.println("Enter the target to find whether there exist 2 elements whose sum equals to target");
        int target=sc.nextInt();
        System.out.println(bst.TwoSum(root, target));
        
    }
}
