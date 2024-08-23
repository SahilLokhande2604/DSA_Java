import java.util.*;
public class BoundaryOfTree {
    Scanner sc=new Scanner(System.in);
    class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public Node BuildTree(Node root){
        System.out.println("Enter data of root node");
        int data=sc.nextInt();
        if(data!=-1){
            root=new Node(data);
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.remove();
            System.out.println("Enter data to left of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                Node newnode=new Node(data);
                curr.left=newnode;
                q.add(newnode);
            }
            System.out.println("Enter data to right of node "+curr.data);
            data=sc.nextInt();
            if(data!=-1){
                Node newnode=new Node(data);
                curr.right=newnode;
                q.add(newnode);
            }
        }
        return root;
    }

    public void LevelOrderTraversal(Node root){
        if(root==null){
            System.out.println("Tree is Empty");
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
    }








    public void LeftBoundry(Node root, ArrayList<Integer>ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        if(root.left!=null){
            ans.add(root.data);
            LeftBoundry(root.left, ans);
        }
        else{
            ans.add(root.data);
            LeftBoundry(root.right, ans);
        }
    }

    public void LeafBoundry(Node root,ArrayList<Integer>ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ans.add(root.data);
            return;
        }
        LeafBoundry(root.left, ans);
        LeafBoundry(root.right, ans);
    }

    public void RightBoundry(Node root,ArrayList<Integer>ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        if(root.right!=null){
            RightBoundry(root.right, ans);
            ans.add(root.data);
        }
        else{
            RightBoundry(root.left, ans);
            ans.add(root.data);
        }
    }


    public void BoundryPrint(Node root){
        if(root==null){
            return;
        }
        ArrayList<Integer>ans=new ArrayList<>();
        LeftBoundry(root, ans);
        LeafBoundry(root, ans);
        RightBoundry(root, ans);
        ans.remove(ans.size()-1);
        display(ans);

    }

    public void display(ArrayList<Integer>arr){
        if(arr.size()==0){
            System.out.println("ArrayList is empty");
            return;
        }
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        BoundaryOfTree bt=new BoundaryOfTree();
        Node root=null;
        root=bt.BuildTree(root);
        System.out.println("Level Order Traversal of tree is");
        bt.LevelOrderTraversal(root);

        bt.BoundryPrint(root);
        

    }
}

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1

// 1 2 4 -1 3 8 11 5 -1 9 10 -1 12 6 -1 -1 -1 -1 -1 13 -1 -1 7 15 16 -1 14 -1 -1 -1 -1 -1 -1