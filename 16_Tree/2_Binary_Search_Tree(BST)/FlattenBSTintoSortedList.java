// given a bst your task is to make it right skewed i.e. the left pointer of each node will point to null and its right pointer will always point to the node greater than current node
import java.util.*;
public class FlattenBSTintoSortedList {
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

    private void InOrder(Node root, List<Node>list){
        if(root==null){
            return;
        }
        InOrder(root.left, list);
        list.add(root);
        InOrder(root.right, list);
    }

    public Node flattenBST(Node root){
        if(root==null){
            return null;
        }
        List<Node>list=new ArrayList<>();
        InOrder(root, list);
        root=list.get(0);
        for(int i=0;i<list.size()-1;i++){
            
            list.get(i).left=null;
            list.get(i).right=list.get(i+1);
            // System.out.println(list.get(i).data+"->"+list.get(i).right.data);
        }
        list.get(list.size()-1).left=null;
        list.get(list.size()-1).right=null;
        return root;
    }

    public static void main(String[] args) {
        FlattenBSTintoSortedList bst=new FlattenBSTintoSortedList();
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

        System.out.println("Flattern BST is");
        root=bst.flattenBST(root);
        bst.InOrderTraversal(root);

    }
}
