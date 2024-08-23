import java.util.*;
public class DiameterOfTree {
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

    public int height(Node root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right) + 1;
    }

    // Time Complexity: O(n^2)
    public int Diameter(Node root){
        if(root==null){
            return 0;
        }
        int op1=Diameter(root.left);
        int op2=Diameter(root.right);
        int op3=height(root.left) + height(root.right) + 1;
        int ans=Math.max(op1,Math.max(op2,op3));
        return ans;
    }


    public int[] DiameterFast(Node root){
        if(root==null){
            
            int[] ans={0,0};
            return ans;
        }

        int[] left=DiameterFast(root.left);
        int[] right=DiameterFast(root.right);

        int op1=left[0];
        int op2=right[0];
        int op3=left[1] + right[1] + 1;

        int[] ans=new int[2];
        ans[0]=Math.max(op1,Math.max(op2,op3)); //diameter
        ans[1]=Math.max(left[1],right[1])+1;    //height
        return ans;

    }

    public int Diameter2(Node root){
        if(root==null){
            return 0;
        }

        return DiameterFast(root)[0];
        
    }
    public static void main(String[] args) {
        DiameterOfTree dt=new DiameterOfTree();
        Node root=null;
        root=dt.BuildTree(root);
        System.out.println("Level order traversal is");
        dt.LevelOrderTraversal(root);

        System.out.println("\nDiameter of Tree is: "+dt.Diameter(root));
        System.out.println("\nDiameter of Tree is: "+dt.Diameter2(root));

        
    }
}   


// 5 3 6 2 4 10 9 -1 -1 -1 -1 -1 -1 5 -1 -1 -1 

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1