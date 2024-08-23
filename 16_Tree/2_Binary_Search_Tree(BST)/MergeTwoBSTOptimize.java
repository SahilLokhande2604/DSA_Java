import java.util.*;;

public class MergeTwoBSTOptimize {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public Node buildBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = buildBST(root.left, data);
        } else {
            root.right = buildBST(root.right, data);
        }
        return root;
    }

    public void InOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(root.data + " ");
        InOrderTraversal(root.right);
    }

    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                }

                System.out.println();

            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        // System.out.println();
    }
    


    
    // it converts bst into DLL by simply performing inorder traversal and storing it in a list to use further to update the left and right pointers
    private void convertBSTtoDLL(Node root, List<Node>inorder){
        if(root==null){
            return;
        }
        convertBSTtoDLL(root.left, inorder);
        inorder.add(root);
        convertBSTtoDLL(root.right, inorder);
    }

    // it merges 2 sorted DLL
    private Node mergeDLL(Node head1, Node head2){
        Node head=null;
        Node tail=null;

        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                if(head==null){
                    head=head1;
                    tail=head1;
                }
                else{
                    tail.right=head1;
                    head1.left=tail;
                    tail=tail.right;
                }
                head1=head1.right;
                
            }
            else{
                if(head==null){
                    head=head2;
                    tail=head2;
                }
                else{
                    tail.right=head2;
                    head2.left=tail;
                    tail=tail.right;
                }  
                head2=head2.right;
            }
        }

        while(head1!=null){
            tail.right=head1;
            head1.left=tail;
            tail=tail.right;
            head1=head1.right;
        }

        while(head2!=null){
            tail.right=head2;
            head2.left=tail;
            tail=tail.right;
            head2=head2.right;
        }

        return head;
    }

    private int lengthOfDLL(Node head){
        int cnt=0;
        Node curr=head;
        while(curr!=null){
            cnt++;
            curr=curr.right;
        }
        return cnt;
    }

    private Node DLLtoBST(Node[] head, int n){
        if(n<=0){
            return null;
        }
        // building left subtree
        Node leftSubTree=DLLtoBST(head, n/2);

        // root node is form
        Node root=head[0];
        if(root!=null){
            root.left=leftSubTree;
        }
        
        if(head[0]!=null){
            head[0]=head[0].right;
        }
        
        // building right subtree
        Node rightSubTree=DLLtoBST(head, n-n/2-1);

        if(root!=null){
            root.right=rightSubTree;
        }
        

        return root;

    }

    // this function is use to updated the left and right pointers so that they point correctly to form a sorted DLL
    private void BSTtoDLL(List<Node>inorder1){
        Node prev=null;
        for(int i=0;i<inorder1.size()-1;i++){
            Node curr=inorder1.get(i);
            curr.left=prev;
            curr.right=inorder1.get(i+1);
            prev=curr;
        }
        inorder1.get(inorder1.size()-1).left=prev;
        inorder1.get(inorder1.size()-1).right=null;
    }

    public Node mergeTwoBST(Node r1, Node r2){
        

        // Storing the inorder of bst into list
        List<Node>inorder1=new ArrayList<>();
        convertBSTtoDLL(r1, inorder1);

        // pointing right pointer to next node and left to its previous
        BSTtoDLL(inorder1);
        Node head1=inorder1.get(0);


        // levelOrderTraversal(head1);
        // System.out.println();
        
        List<Node>inorder2=new ArrayList<>();
        convertBSTtoDLL(r2, inorder2);

        BSTtoDLL(inorder2);
        Node head2=inorder2.get(0);

        // levelOrderTraversal(head2);
        // System.out.println();

        // merge 2 DLL
        Node head=mergeDLL(head1,head2);

        int n=lengthOfDLL(head);
        
        Node[] h={head};

        return DLLtoBST(h,n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeTwoBSTOptimize bst = new MergeTwoBSTOptimize();

        Node root1 = null, root2 = null;
        System.out.println("Enter data into 1st BST to stop enter -1");
        int data = sc.nextInt();
        while (data != -1) {
            root1 = bst.buildBST(root1, data);
            data = sc.nextInt();
        }
        System.out.println("Enter data into 2nd BST to stop enter -1");
        data = sc.nextInt();
        while (data != -1) {
            root2 = bst.buildBST(root2, data);
            data = sc.nextInt();
        }

        System.out.println("Inorder of 1st bst is");
        bst.InOrderTraversal(root1);
        System.out.println();
        System.out.println("Inorder of 2nd bst is");
        bst.InOrderTraversal(root2);
        System.out.println();

        System.out.println("BST after merge is ");

        Node root=bst.mergeTwoBST(root1,root2);
        bst.levelOrderTraversal(root);

        System.out.println("Inorder traversal is ");
        bst.InOrderTraversal(root);
    


    }

}

// 50 40 60 70 -1

// 55 45 65 35 47 -1
