import java.util.*;

public class ZigZagTreeTraversal {
    Scanner sc=new Scanner(System.in);
    public class Node{
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
        Queue<Node>q=new LinkedList<>();
        System.out.println("Enter the data to node (to make node null enter -1)");
        int data=sc.nextInt();
        if(data!=-1){
            root=new Node(data);
            q.add(root);
        }
        
        
        while(!q.isEmpty()){
            Node curr=q.remove();
            System.out.println("Enter data to left of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                Node node=new Node(data);
                curr.left=node;
                q.add(node);
            }
            System.out.println("Enter data to right of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                Node node=new Node(data);
                curr.right=node;
                q.add(node);
            }

        }

        return root;
    }

    public void LevelOrderTraversal(Node root){
        if(root==null){
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                if(!q.isEmpty()){
                    System.out.println();
                    q.add(null);
                }
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
    }

    public ArrayList<Integer> ZigZagTraversal(Node root){
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);

        boolean LeftToRight=true;

        while(!q.isEmpty()){
            int size=q.size();
           
            ArrayList<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr=q.remove();
                if(LeftToRight){
                    temp.add(curr.data);
                }
                else{
                    temp.add(0,curr.data);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            for(int i=0;i<temp.size();i++){
                ans.add(temp.get(i));
            }
            LeftToRight=!LeftToRight;
            
        }


        return ans;
    }
    public static void main(String[] args) {

        ZigZagTreeTraversal zz=new ZigZagTreeTraversal();
        Node root=null;
        root=zz.BuildTree(root);
        zz.LevelOrderTraversal(root);
        System.out.println("\nZig Zag Tree Traversal is ");
        ArrayList<Integer>ans=zz.ZigZagTraversal(root);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
    }

}

// 5 3 6 2 4 10 9 -1 -1 -1 -1 -1 -1 5 -1 -1 -1 

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1