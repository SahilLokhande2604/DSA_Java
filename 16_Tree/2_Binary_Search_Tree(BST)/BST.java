import java.util.*;
public class BST {
    class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public Node insert(Node root, int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        else if(data<root.data){
            root.left=insert(root.left,data);
        }
        else{
            root.right=insert(root.right,data);
        }
        return root;
    }

    public boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        else if(key<root.data){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }

    public Node delete(Node root,int data){
        if(root==null){
            return root;
        }
        if(root.data==data){
            // 0 child case
            if(root.left==null && root.right==null){
                return null;
            }

            // 1 child case
            if(root.left!=null && root.right==null){
                Node temp=root.left;
                root=null;
                return temp;
            }
            if(root.left==null && root.right!=null){
                Node temp=root.right;
                root=null;
                return temp;
            }
            // 2 child case
            if(root.left!=null && root.right!=null){
                int mini=findMini(root.right);
                root.data=mini;
                root.right=delete(root.right, mini);
                return root;
            }
        }
        else if(root.data>data){
            root.left=delete(root.left,data);
        }
        else{
            root.right=delete(root.right,data);
        }
        return root;
    }

    public int findMini(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root.data;

    }


    public void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr=q.poll();
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


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        Node root=null;
        System.out.println("Enter data into bst to stop enter -1");
        int data=sc.nextInt();
        while(data!=-1){
            root=bst.insert(root, data);
            data=sc.nextInt();
        }
        System.out.println("LEvel order traversal is ");
        bst.levelOrderTraversal(root);
        
        System.out.println();
        // boolean flag=true;
        // while(flag){
        //     System.out.println("Enter data to search into bst");
        //     int key=sc.nextInt();
        //     System.out.println("Key is present in bst "+bst.search(root, key));

        //     System.out.println("Enter data to delete from bst");
        //     data=sc.nextInt();
        //     System.out.println();
        //     root=bst.delete(root, data);
        //     System.out.println();
        //     bst.levelOrderTraversal(root);

        //     System.out.println("To continue enter any number \nto stop enter -1");
        //     int stop=sc.nextInt();
        //     if(stop==-1){
        //         flag=false;
        //     }


        // }
        

    }
}

// 15 10 20 5 13 17 25 4 7 12 14 19 23 30 3 18 -1