import java.util.*;

public class MergeTwoBST {
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

    public void levelOrderTraversal(Node root){
        if(root==null){
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
        // System.out.println();
    }

    private void InOrder(Node root, List<Integer>list){
        if(root==null){
            return;
        }
        InOrder(root.left, list);
        list.add(root.data);
        InOrder(root.right, list);
    }

    private Node buildBSTFromInorder(List<Integer>inorder, int start, int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;

        Node root=new Node(inorder.get(mid));
        root.left=buildBSTFromInorder(inorder, start, mid-1);
        root.right=buildBSTFromInorder(inorder, mid+1, end);

        return root;
    }

    public Node merge(Node r1, Node r2){
        if(r1==null && r2==null){
            return null;
        }
        if(r1!=null && r2==null){
            return r1;
        }
        if(r1==null && r2!=null){
            return r2;
        }


        // Step 1 : find Inorder of both the bst


        List<Integer>inorder1=new ArrayList<>();
        List<Integer>inorder2=new ArrayList<>();
        InOrder(r1,inorder1);
        InOrder(r2,inorder2);

        //Step 2:  Merge 2 sorted list 


        List<Integer>inorder=new ArrayList<>();
        int s1=0,s2=0;
        while(s1<inorder1.size() && s2<inorder2.size()){
            if(inorder1.get(s1)<=inorder2.get(s2)){
                inorder.add(inorder1.get(s1));
                s1++;
            }
            else{
                inorder.add(inorder2.get(s2));
                s2++;
            }
        }

        while(s1<inorder1.size()){
            inorder.add(inorder1.get(s1));
            s1++;
        }

        while(s2<inorder2.size()){
            inorder.add(inorder2.get(s2));
            s2++;
        }

        // Step 3: Build BST from inorder traversal
        int[] index={0};
        return buildBSTFromInorder(inorder,0, inorder.size()-1);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MergeTwoBST bst=new MergeTwoBST();

        Node root1=null,root2=null;
        System.out.println("Enter data into 1st BST to stop enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            root1=bst.buildBST(root1, data);
            data=sc.nextInt();
        }
        System.out.println("Enter data into 2nd BST to stop enter -1");
        data=sc.nextInt();
        while(data!=-1){
            root2=bst.buildBST(root2, data);
            data=sc.nextInt();
        }

        System.out.println("Inorder of 1st bst is");
        bst.InOrderTraversal(root1);
        System.out.println();
        System.out.println("Inorder of 2nd bst is");
        bst.InOrderTraversal(root2);
        System.out.println();

        System.out.println("BST after merge is ");
        Node root=bst.merge(root1, root2);
        bst.levelOrderTraversal(root);
        System.out.println("Inorder Traversal of merge BST is");
        bst.InOrderTraversal(root);

    }

}

//  50 40 60 70 -1

// 55 45 65 35 47 -1