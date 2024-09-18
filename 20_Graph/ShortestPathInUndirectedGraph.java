import java.util.*;
public class ShortestPathInUndirectedGraph {

    public void shortestPath(int nodes, int edges, int[][] edge, int src, int dest){
        // create adjList
        List<List<Integer>>adjList=new ArrayList<>(nodes);
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // create a visited array and parent array
        boolean[] visited=new boolean[nodes];
        int[] parent=new int[nodes];

        // create a queue to perform bfs
        Queue<Integer>queue=new LinkedList<>();
        queue.add(src);
        visited[src]=true;
        parent[src]=-1;

        while(!queue.isEmpty()){
            int front=queue.remove();
            for(int neigbour: adjList.get(front)){
                if(!visited[neigbour]){
                    visited[neigbour]=true;
                    parent[neigbour]=front;
                    queue.add(neigbour);
                }
            }
        }

        // backtrack the shortest path from destination node to source node using parent array
        int cost=0;
        List<Integer>path=new ArrayList<>();
        int currentNode=dest;
        path.add(currentNode);

        while(currentNode!=src){
            currentNode=parent[currentNode];
            path.add(currentNode);
            cost++;
        }

        System.out.println("Shortest Path is");
        for(int i=path.size()-1;i>=0;i--){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
        System.out.println("The cost using shortest path is "+cost);
    }
    public static void main(String a[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes");
        int nodes=sc.nextInt();
        System.out.println("Enter the no. of edges");
        int edges=sc.nextInt();
        int[][] edge=new int[edges][2];
        System.out.println("Enter the node pairs connected with edges");
        for(int i=0;i<edges;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }

        ShortestPathInUndirectedGraph spiug = new ShortestPathInUndirectedGraph();
        System.out.println("Enter the source node");
        int src=sc.nextInt();
        System.out.println("Enter the destination node");
        int dest=sc.nextInt();
        spiug.shortestPath(nodes,edges,edge,src,dest);
    }
}

// Enter the no. of nodes
// 8
// Enter the no. of edges
// 9
// Enter the node pairs connected with edges
// 0 1   
// 0 2
// 0 3
// 1 4
// 2 7
// 3 5
// 4 7
// 5 6
// 6 7
// Enter the source node
// 0
// Enter the destination node
// 7
// Shortest Path is
// 0->2->7->
// The cost using shortest path is 2
