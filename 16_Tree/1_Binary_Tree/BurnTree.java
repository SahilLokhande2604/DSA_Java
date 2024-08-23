import java.util.*;

public class BurnTree {
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

    public Node BuildTree(Node root) {
        System.out.println("Enter data of root node");
        int data = sc.nextInt();
        if (data != -1) {
            root = new Node(data);
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            System.out.println("Enter data to left of node " + curr.data);
            data = sc.nextInt();
            if (data != -1) {
                Node newnode = new Node(data);
                curr.left = newnode;
                q.add(newnode);
            }
            System.out.println("Enter data to right of node " + curr.data);
            data = sc.nextInt();
            if (data != -1) {
                Node newnode = new Node(data);
                curr.right = newnode;
                q.add(newnode);
            }
        }
        return root;
    }

    public void LevelOrderTraversal(Node root) {
        if (root == null) {
            System.out.println("Tree is Empty");
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
    }

    private void childToParent(Node node, HashMap<Node, Node> childParent) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            childParent.put(node.left, node);
        }
        if (node.right != null) {
            childParent.put(node.right, node);
        }
        childToParent(node.left, childParent);
        childToParent(node.right, childParent);
    }

    private Node findTarget(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;
        }
        Node left = findTarget(root.left, target);
        Node right = findTarget(root.right, target);
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

    public int TimeToBurnTree(Node root, int target) {
        if (root == null) {
            return 0;
        }
        int time = 0;
        HashMap<Node, Node> childParent = new HashMap<>();
        childParent.put(root, null);
        childToParent(root, childParent);

        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        Node targetNode = findTarget(root, target);

        q.add(targetNode);

        visited.add(targetNode);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                    flag = true;
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                    flag = true;
                }
                Node parent = childParent.get(curr);
                if (!visited.contains(parent) && parent != null) {
                    q.add(parent);
                    visited.add(parent);
                    flag = true;
                }
            }

            if (flag) {
                time++;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BurnTree bt = new BurnTree();
        Node root = null;
        root = bt.BuildTree(root);
        bt.LevelOrderTraversal(root);
        System.out.println("Enter the target node value");
        int target = sc.nextInt();
        System.out.println("Time to burn complete tree is : " + bt.TimeToBurnTree(root, target));
    }
}

// 1 2 3 4 5 -1 6 -1 -1 7 8 -1 9 -1 -1 -1 -1 -1 10 -1 -1