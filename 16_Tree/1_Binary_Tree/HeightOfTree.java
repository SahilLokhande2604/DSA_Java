import java.util.*;

public class HeightOfTree {
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
        int right=height(root.right);
        int left=height(root.left);
        return Math.max(right,left)+1;
    }

    public void heightOfTree(Node root,int[] height,int[] max){
        if(root==null){
            max[0]=Math.max(max[0],height[0]);
            return;
        }
        height[0]++;
        heightOfTree(root.left, height,max);
        heightOfTree(root.right, height,max);
        height[0]--;
    }


    
    public static void main(String[] args) {
        HeightOfTree ht=new HeightOfTree();
        Node root=null;
        root=ht.BuildTree(root);
        System.out.println("Level order traversal is");
        ht.LevelOrderTraversal(root);
        System.out.println("\nHeight of tree is :"+ht.height(root));

        int[] height={0};
        int[] max={0};
        ht.heightOfTree(root, height, max);
        System.out.println("\nHeight of tree is ="+max[0]);

        
    }
}
// 5 3 6 2 4 10 9 -1 -1 -1 -1 -1 -1 5 -1 -1 -1 