import java.util.*;

public class DiagonalView {
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

    public void fastDiagonalView(Node root,HashMap<Integer,ArrayList<Integer>>map,int distance){
        if(root==null){
            return;
        }
        if(map.containsKey(distance)){
            map.get(distance).add(root.data);
        }
        else{
            ArrayList<Integer>arr=new ArrayList<>();
            arr.add(root.data);
            map.put(distance,arr);
        }

        fastDiagonalView(root.left, map, distance+1);
        fastDiagonalView(root.right, map, distance);
    }

    public static void display(ArrayList<Integer>arr){
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }

    

    

    public void diagonalView(Node root) {
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();

        fastDiagonalView(root, map, 0);

        Iterator<Map.Entry<Integer, ArrayList<Integer>>> itr = map.entrySet().iterator();

        while(itr.hasNext()) 
        { 
            Map.Entry<Integer, ArrayList<Integer>> entry = itr.next(); 
            ArrayList<Integer>arr=entry.getValue(); 
            display(arr);
        } 
    }

    

    public static void main(String args[]) {
        DiagonalView dv = new DiagonalView();
        Node root = null;
        root = dv.BuildTree(root);
        System.out.println("Level Order Traversal of tree is");
        dv.LevelOrderTraversal(root);
        System.out.println("Diagonal View of tree is ");
        dv.diagonalView(root);

    }
}

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1

// 1 2 4 -1 3 8 11 5 -1 9 10 -1 12 6 -1 -1 -1 -1 -1 13 -1 -1 7 15 16 -1 14 -1 -1 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 10 -1 11 -1 -1 -1 -1 -1

// 8 3 10 1 -1 6 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1 