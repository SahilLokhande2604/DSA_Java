import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SumTree {
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
        int sum;
        boolean isSumTree;
        
        Pair(int sum,boolean isSumTree){
            this.sum=sum;
            this.isSumTree=isSumTree;
        }
    }

    public Pair fastSumTree(Node root){
        // base case
        if(root==null){
            Pair p=new Pair(0,true);
            return p;
        }
        // leaf-node
        if(root.left==null && root.right==null){
            Pair p=new Pair(root.data,true);
            return p;
        }

        Pair leftSubTree=fastSumTree(root.left);
        Pair rightSubTree=fastSumTree(root.right);
        int sum=leftSubTree.sum+rightSubTree.sum;
        Pair ans;
        if(leftSubTree.isSumTree && rightSubTree.isSumTree && root.data==sum){
            ans=new Pair(sum+root.data,true);
        }
        else{
            ans=new Pair(sum,false);
        }
        return ans;


    }

    

    public boolean isSumTree(Node root){
        if(root==null){
            return true;
        }
        return fastSumTree(root).isSumTree;
    }

    
    public static void main(String[] args) {
        SumTree st=new SumTree();
        Node root=null;
        root=st.BuildTree(root);
        System.out.println("Level order traversal is");
        st.LevelOrderTraversal(root);

        System.out.println("The given tree is Sum Tree? "+st.isSumTree(root));

        
// 70 20 30 10 10 -1 -1 -1 -1 -1 -1 

        
    }
}
