import java.util.*;
public class TopView {
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

    class Pair{
        int index;
        Node node;
        Pair(Node node,int index){
            this.index=index;
            this.node=node;
        }
    }

    public void fastTopView(Node root,SortedMap<Integer,Integer>map){
        if(root==null){
            return;
        }
        int index=0;
        Queue<Pair>q=new LinkedList<>();
        Pair pair=new Pair(root,index);
        q.add(pair);
        while(!q.isEmpty()){
            Pair curr=q.remove();
            if(!map.containsKey(curr.index)){
                map.put(curr.index,curr.node.data);
            }
            if(curr.node.left!=null){
                Pair p=new Pair(curr.node.left,curr.index-1);
                q.add(p);
            }
            if(curr.node.right!=null){
                Pair p=new Pair(curr.node.right,curr.index+1);
                q.add(p);
            }
        }
        

        

    }

    public void topView(Node root){
        SortedMap<Integer,Integer>map=new TreeMap<>();
        fastTopView(root, map);
        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator(); 
          
        while(itr.hasNext()) 
        { 
            Map.Entry<Integer, Integer> entry = itr.next(); 
            System.out.print(entry.getValue()+" "); 
        } 
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
        TopView tv=new TopView();
        Node root=null;
        root=tv.BuildTree(root);
        System.out.println("Level Order Traversal of tree is");
        tv.LevelOrderTraversal(root);
        tv.topView(root);
        

    }
}

// 1 2 3 4 5 -1 8 -1 -1 6 7 9 10 -1 -1 -1 -1 11 12 -1 -1 -1 -1 -1 -1

// 1 2 4 -1 3 8 11 5 -1 9 10 -1 12 6 -1 -1 -1 -1 -1 13 -1 -1 7 15 16 -1 14 -1 -1 -1 -1 -1 -1

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1 

//  1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 -1 -1 -1 -1 

// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 10 -1 11 -1 -1 -1 -1 -1 