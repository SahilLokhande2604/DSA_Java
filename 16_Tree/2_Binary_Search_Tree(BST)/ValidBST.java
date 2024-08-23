import java.util.*;

public class ValidBST {
    Scanner sc = new Scanner(System.in);

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node buildBST(Node root) {
        System.out.println("Enter the data");
        int data = sc.nextInt();
        Queue<Node> q = new LinkedList<>();
        if (data != -1) {
            root = new Node(data);
        }
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();

            System.out.println("Enter data to left of node " + curr.data);
            data = sc.nextInt();
            if (data != -1) {
                curr.left = new Node(data);
                q.add(curr.left);
            } else {
                curr.left = null;
            }

            System.out.println("Enter data to right of node " + curr.data);
            data = sc.nextInt();
            if (data != -1) {
                curr.right = new Node(data);
                q.add(curr.right);
            } else {
                curr.right = null;
            }

        }
        return root;
    }

    public void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    private boolean isValidBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data >= min && root.data <= max) {
            boolean left = isValidBST(root.left, min, root.data);
            boolean right = isValidBST(root.right, root.data, max);
            return left && right;
        }
        return false;

    }

    public boolean isValid(Node root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] a) {
        ValidBST bst = new ValidBST();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the data into BST for null enter -1");

        Node root = null;

        root = bst.buildBST(root);

        System.out.println("Inorder traversal is");
        bst.Inorder(root);
        System.out.println("\nIs valid BST"+bst.isValid(root));

    }
}
