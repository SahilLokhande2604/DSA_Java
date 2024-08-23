// Given a BST which is a complete binary tree your task is to convert it into min. heap such that for each node its left child should be greater than it and right child should be greater than left child

// i.e root < left < right

import java.util.*;
public class ConvertBSTintoMinHeap {
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

    private void inorderTraversal(Node root, List<Integer>inorder){
        if(root==null){
            return;
        }
        inorderTraversal(root.left,inorder);
        inorder.add(root.data);
        inorderTraversal(root.right, inorder);
    }
    private void convert(Node root, List<Integer>inorder, int[] index){
        if(root==null){
            return;
        }
        root.data=inorder.get(index[0]);
        index[0]++;

        convert(root.left, inorder, index);
        convert(root.right, inorder, index);
    }

    public Node convertBSTintoMinHeap(Node root){
        List<Integer>inorder=new ArrayList<>();
        inorderTraversal(root,inorder);

        int[] index={0};
        convert(root,inorder,index);
        return root;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data into BST to stop enter -1 tree must be complete binary tree");
        ConvertBSTintoMinHeap bst=new ConvertBSTintoMinHeap();

        int data=sc.nextInt();
        Node root=null;
        while(data!=-1){
            root=bst.buildBST(root,data);
            data=sc.nextInt();
        }
        bst.LevelOrderTraversal(root);

        root=bst.convertBSTintoMinHeap(root);

        bst.LevelOrderTraversal(root);


    }
}


// 4 2 6 1 3 5 7 -1