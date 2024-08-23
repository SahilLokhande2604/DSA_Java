import java.util.*;
public class LargestBSTinBinaryTree {
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

    public Node buildBinaryTree(Node root){
        System.out.println("Enter the data");
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
            System.out.println("Enter data to left of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                curr.left=new Node(data);
                q.add(curr.left);
            }
            System.out.println("Enter data to right of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                curr.right=new Node(data);
                q.add(curr.right);
            }
        }
        return root;
    }

    public void LevelOrderTraversal(Node root){
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

    class Info{
        int mini;
        int maxi;
        boolean isBST;
        int size;

        Info(int mini, int maxi, boolean isBST, int size){
            this.mini=mini;
            this.maxi=maxi;
            this.isBST=isBST;
            this.size=size;
        }
    }

    private Info solve(Node root, int[] ans){
        if(root==null){
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }
        if(root.left==null && root.right==null){
            return new Info(root.data, root.data, true, 1);
        }

        Info left=solve(root.left,ans);
        Info right=solve(root.right,ans);

        boolean isBST=left.isBST && right.isBST && (left.maxi<root.data && right.mini>root.data);
        int mini=Math.min(left.mini,root.data);
        int maxi=Math.max(root.data,right.maxi);
        int size=left.size + right.size + 1;
        if(isBST){
            ans[0]=Math.max(ans[0],size);
        }

        return new Info(mini, maxi, isBST, size);
    }

    public int largestBSTinBT(Node root){
        int[] ans={0};
        solve(root,ans);
        return ans[0];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        LargestBSTinBinaryTree bst=new LargestBSTinBinaryTree();
        Node root=null;

        System.out.println("Enter the data into Binary Tree to enter null enter -1");
        root=bst.buildBinaryTree(root);

        System.out.println("Level Order Traversal is");
        bst.LevelOrderTraversal(root);

        System.out.println("Size of largest BST in given Binary Tree is");
        System.out.println(bst.largestBSTinBT(root));
    }
}

// 10 5 20 4 -1 15 25 1 5 13 -1 -1 -1 -1 -1 -1 -1 -1 14 -1 -1 