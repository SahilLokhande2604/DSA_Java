import java.util.*;
public class ShortestPathInDAG {

    private class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
    }

    private void dfs(List<List<Pair>>adjList, boolean[] visited, Stack<Integer>stack, int node){
        visited[node]=true;

        List<Pair>children=adjList.get(node);
        for(Pair child: children){
            if(!visited[child.node]){
                dfs(adjList,visited,stack,child.node);
            }
        }
        stack.add(node);
    }

    public void shortestPath(int nodes, int edges, int[][] edge, int src){
        // create adjList node->{ [child1, weight1], [child2,weight2] }
        List<List<Pair>>adjList=new ArrayList<>(nodes);

        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            int w=edge[i][2];
            adjList.get(u).add(new Pair(v,w));
        }

        // perfoem topological sort and store result in stack
        Stack<Integer>stack=new Stack<>();
        boolean[] visited=new boolean[nodes];

        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                dfs(adjList, visited, stack, i);
            }
        }

        // create a distance array to store distance from src to all other nodes
        int[] distance=new int[nodes];
        for(int i=0;i<nodes;i++){
            distance[i]=Integer.MAX_VALUE;
        }

        distance[src]=0;
        while(!stack.isEmpty()){
            int node=stack.pop();
            if(distance[node]!=Integer.MAX_VALUE){
                for(Pair child: adjList.get(node)){
                    if(distance[node] + child.weight < distance[child.node]){
                        distance[child.node]= distance[node] + child.weight;
                    }
                }
            }
        }

        System.out.println("Distance array is");
        for(int i=0;i<nodes;i++){
            System.out.print(distance[i]+" ");
        }
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes");
        int nodes=sc.nextInt();
        System.out.println("Enter the no. of edges");
        int edges=sc.nextInt();
        System.out.println("Enter the pair of nodes connected with edge along with weight of edge");
        int[][] edge=new int[edges][3];
        for(int i=0;i<edges;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
            edge[i][2]=sc.nextInt();
        }

        ShortestPathInDAG spdag=new ShortestPathInDAG();
        System.out.println("Enter the source node from which you want to find shortest path to all other nodes");
        int src=sc.nextInt();
        spdag.shortestPath(nodes, edges, edge, src);
    }
}


// Enter the no. of nodes
// 6
// Enter the no. of edges
// 9
// Enter the pair of nodes connected with edge along with weight of edge
// 0 1 5
// 0 2 3
// 1 2 2
// 2 3 7
// 2 4 4
// 2 5 2
// 3 4 -1
// 4 5 -2
// 1 3 6
// Enter the source node from which you want to find shortest path to all other nodes
// 1
// Distance array is
// 2147483647 0 2 6 5 3 