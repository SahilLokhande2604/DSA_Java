import java.util.*;

public class CountLeafNodes {
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

    private void InOrderTraversal(Node root, int[] count){
        if(root==null){
            return;
        }
        InOrderTraversal(root.left, count);
        if(root.left==null && root.right==null){
            count[0]++;
        }
        InOrderTraversal(root.right, count);
    }

    public int countLeafNode(Node root){
        int[] count=new int[1];
        InOrderTraversal(root, count);
        return count[0];
    }
    public static void main(String[] args) {
        CountLeafNodes cln=new CountLeafNodes();
        Node root=null;
        root=cln.BuildTree(root);
        System.out.println("Level order traversal is");
        cln.LevelOrderTraversal(root);

        System.out.println("\nNo. of Leaf Nodes are :"+cln.countLeafNode(root));
    }
}
