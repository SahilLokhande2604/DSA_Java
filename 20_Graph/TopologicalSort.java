import java.util.*;
public class TopologicalSort {

    public void dfs(List<List<Integer>>adjList, boolean[] visited, int node, Stack<Integer>stack){
        visited[node]=true;
        List<Integer>children=adjList.get(node);
        for(int child:children){
            if(!visited[child]){
                dfs(adjList, visited, child, stack);
            }
        }
        stack.add(node);

    }

    public void topologicalSort(int nodes, int edges, int[][] connections){

        // create adjList
        List<List<Integer>>adjList=new ArrayList<>(nodes);
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges;i++){
            int u=connections[i][0];
            int v=connections[i][1];

            adjList.get(u).add(v);
        }

        // create visited list to track visited nodes
        boolean[] visited=new boolean[nodes];

        // use stack to store the nodes from which we cant traverse further/ans
        Stack<Integer>stack=new Stack<>();

        // iterate over each node and perform dfs 
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                dfs(adjList, visited, i, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes present in graph");
        int nodes=sc.nextInt();
        System.out.println("Enter the no. of edges present in graph");
        int edges=sc.nextInt();

        int[][] connections=new int[edges][2];

        System.err.println("Enter the node pairs connected with each other");
        for(int i=0;i<edges;i++){
            connections[i][0]=sc.nextInt();
            connections[i][1]=sc.nextInt();
        }

        TopologicalSort ts=new TopologicalSort();
        ts.topologicalSort(nodes, edges, connections);


    }
}


// 6
// 7
// 0 1
// 0 2
// 1 3
// 2 3
// 3 4
// 3 5
// 4 5