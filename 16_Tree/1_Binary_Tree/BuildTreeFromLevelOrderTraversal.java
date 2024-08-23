import java.util.*;
public class BuildTreeFromLevelOrderTraversal {
    Scanner sc=new Scanner(System.in);
    class Node{
        int data;
        Node left,right;

        Node(){

        }

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }


    }

    public Node BuildTree(Node root){
        Queue<Node>queue=new LinkedList<>();
        System.out.println("Enter the data");
        int data=sc.nextInt();
        if(data!=-1){
            root=new Node(data);
            queue.add(root);
        }
        while(!queue.isEmpty()){
            Node curr=queue.remove();
            System.out.println("Enter data to left of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                Node newnode=new Node(data);
                curr.left=newnode;
                queue.add(newnode);
            }

            System.out.println("Enter data to right of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                Node newnode=new Node(data);
                curr.right=newnode;
                queue.add(newnode);
            }
        }
        return root;

    }

    public void LevelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node>queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node curr=queue.remove();
            if(curr==null){
                if(!queue.isEmpty()){
                    System.out.println();
                    queue.add(null);
                }
            }
            else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        BuildTreeFromLevelOrderTraversal bt=new BuildTreeFromLevelOrderTraversal();
        Node root=null;
        // Node tree=new Node();
        root=bt.BuildTree(root);
        System.out.println("Level order traversal is");
        bt.LevelOrderTraversal(root);
        
    }
}

// 5 3 6 2 4 -1 -1 1 -1 -1 -1  -1 -1 
