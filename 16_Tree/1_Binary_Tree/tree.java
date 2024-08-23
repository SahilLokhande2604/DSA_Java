import java.util.*;
public class tree {
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

        public Node buildTree(Node root){
            System.out.println("Enter the data");
            int data=sc.nextInt();
            if(data==-1){
                return null;
            }
            root=new Node(data);

            System.out.println("Add node to left of node "+data);
            root.left=buildTree(root.left);

            System.out.println("Add node to right of node "+data);
            root.right=buildTree(root.right);

            return root;

        }
    }

    public void display(Node root){
        if(root==null){
            return;
        }
            display(root.left);
        
        System.out.print(root.data +" ");
  
            display(root.right);
        

    }

    public void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node temp=q.remove();
            if(!q.isEmpty() && temp==null){
                System.out.println();
                q.add(null);
            }
           
            else{
                if(!q.isEmpty()){
                    System.out.print(temp.data+" ");
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                }
                
            }

            
        }

    }

    public static void main(String args[]){
        
        System.out.println("Enter the data to tree");
        tree t1=new tree();
        Node node=t1.new Node();
        Node root=null;
        root=node.buildTree(root);
        System.out.println("root="+root.data);
        t1.display(root);
        System.out.println();
        t1.levelOrderTraversal(root);
        

    }
}
