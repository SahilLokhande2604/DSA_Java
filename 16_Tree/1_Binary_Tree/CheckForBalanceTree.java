import java.util.*;

public class CheckForBalanceTree {
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

    public class Pair{
        int height;
        boolean isBalanced;
        
        Pair(int height,boolean isBalanced){
            this.height=height;
            this.isBalanced=isBalanced;
        }
    }

    public Pair fastIsbalance(Node root){
        if(root==null){
            Pair p=new Pair(0,true);
            return p;
        }

        Pair leftPair=fastIsbalance(root.left);
        Pair rightPair=fastIsbalance(root.right);

        int height=Math.max(leftPair.height,rightPair.height)+1;
        Pair ans;
        if(leftPair.isBalanced && rightPair.isBalanced && Math.abs(leftPair.height-rightPair.height)<=1){
            ans=new Pair(height,true);
        }
        else{
            ans=new Pair(height,false);
        }
        return ans;
        
    }

    public boolean isBalanced(Node root){
        if(root==null){
            return true;
        }
        return fastIsbalance(root).isBalanced;
    }

    
    public static void main(String[] args) {
        CheckForBalanceTree bt=new CheckForBalanceTree();
        Node root=null;
        root=bt.BuildTree(root);
        System.out.println("Level order traversal is");
        bt.LevelOrderTraversal(root);

        System.out.println("The given tree is Balanced? "+bt.isBalanced(root));

        
// 5 3 6 2 4 10 9 -1 -1 -1 -1 -1 -1 5 -1 -1 -1 

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1

        
    }
}
