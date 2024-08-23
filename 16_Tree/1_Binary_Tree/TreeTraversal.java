import java.util.*;

public class TreeTraversal {
    Scanner sc=new Scanner(System.in);

    class Node{
        int data;
        Node left;
        Node right;

        Node(){

        }

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

        public Node buildTree(Node root){
            System.out.println("Enter the data ");
            int data=sc.nextInt();
            if(data==-1){
                return null;
            }
            root=new Node(data);
            System.out.println("Enter data to left of node "+root.data);
            root.left=buildTree(root.left);
            
            System.out.println("Enter data to right of node "+root.data);
            root.right=buildTree(root.right);
           

            return root;

        }

        public void LevelOrderTraversal(Node node){
            if(node==null){
                System.out.println("Tree is empty");
                return;
            }
            Queue<Node>queue=new LinkedList<>();
            System.out.println("Level Order Traversal is:");
            queue.add(node);
            queue.add(null);
            while(!queue.isEmpty()){
                Node temp=queue.remove();
                if(temp==null){
                    System.out.println();
                    if(!queue.isEmpty()){
                        queue.add(null);
                    }
                }
                else{
                    System.out.print(temp.data+" ");
                    if(temp.left!=null){
                        queue.add(temp.left);
                    }
                    if(temp.right!=null){
                        queue.add(temp.right);
                    }
                }
            }
        }

        public void ReverseLevelOrderTraversal(Node root){
            if(root==null){
                return;
            }
            Stack<Node>stack=new Stack<>();
            Queue<Node>queue=new LinkedList<>();
            stack.push(root);
            stack.push(null);
            queue.add(root);
            queue.add(null);
            while(!queue.isEmpty()){
                Node curr=queue.remove();
                if(curr==null){
                    if(!queue.isEmpty()){
                        queue.add(null);
                        stack.push(null);
                    }
                }
                else{
                    
                    if(curr.right!=null){
                        stack.push(curr.right);
                        queue.add(curr.right);
                    }
                    if(curr.left!=null){
                        stack.push(curr.left);
                        queue.add(curr.left);
                    }
                }
                
            }
            while(!stack.isEmpty()){
                Node curr=stack.pop();
                if(curr==null){
                    System.out.println();
                }
                else{
                    System.out.print(curr.data+" ");
                }
            }
        }

        public void InOrderTraversal(Node node){
            if(node==null){
                return;
            }
            InOrderTraversal(node.left);
            System.out.print(node.data+" ");
            InOrderTraversal(node.right);

        }

        public void PreOrderTraversal(Node node){
            if(node==null){
                return;
            }
            System.out.print(node.data+" ");
            PreOrderTraversal(node.left);
            PreOrderTraversal(node.right);
        }

        public void PostOrderTraversal(Node node){
            if(node==null){
                return;
            }
            PostOrderTraversal(node.left);
            PostOrderTraversal(node.right);
            System.out.print(node.data+" ");
        }

        public void IterativeInOrderTraversal(Node node){
            Stack<Node>stack=new Stack<>();
            stack.push(node);
            node=node.left;
            while(node!=null || !stack.isEmpty()){
                while(node!=null){
                    stack.push(node);
                    node=node.left;
                }
                node=stack.pop();
                System.out.print(node.data+" ");
                node=node.right;
            }
        }

        public void IterativePreOrderTraversal(Node root){
            Stack<Node>stack=new Stack<>();
            stack.push(root);
            root=root.left;
            System.out.print(stack.peek().data+" ");
            while(root!=null || !stack.isEmpty()){
                
                while(root!=null){
                    stack.push(root);
                    System.out.print(stack.peek().data+" ");
                    root=root.left;
                }
                root=stack.pop();
                root=root.right;

            }
        }

        public void IterativePostOrderTraversal(Node root){
            Stack<Node>stack=new Stack<>();
            Node visited=null;
            stack.push(root);
            root=root.left;
            while(root!=null || !stack.isEmpty()){
                while(root!=null && root!=visited){
                    stack.push(root);
                    root=root.left;
                }
                if(root==visited){
                    System.out.print(root.data+" ");
                    stack.pop();
                    root=stack.peek();
                    continue;
                }
                
                root=stack.peek().right;
                if(root==null){
                    root=stack.pop();
                    System.out.print(root.data+" ");
                    root=stack.peek();
                    visited=root;
                }
            }
        }
    }
    public static void main(String[] args){
        TreeTraversal tt=new TreeTraversal();
        Node tree=tt.new Node();
        Node root=null;
        
        root=tree.buildTree(root);

        tree.LevelOrderTraversal(root);
        System.out.println("\nReverse Level Order Traversal is:");
        tree.ReverseLevelOrderTraversal(root);
        System.out.println("\nIn Order Traversal is:");
        tree.InOrderTraversal(root);
        System.out.println("\nPre Order Traversal is:");
        tree.PreOrderTraversal(root);
        System.out.println("\nPost Order Traversal is:");
        tree.PostOrderTraversal(root);

        System.out.println("\nIterative In Order Traversal is:");
        tree.IterativeInOrderTraversal(root);

        System.out.println("\nIterative Pre Order Traversal is:");
        tree.IterativePreOrderTraversal(root);

        // System.out.println("\nIterative Post Order Traversal is:");
        // tree.IterativePostOrderTraversal(root);
        

// 4 1 0 -1 -1 2 -1 3 -1 -1 6 5 -1 -1 7 -1 8 -1 -1
        


    }
}
