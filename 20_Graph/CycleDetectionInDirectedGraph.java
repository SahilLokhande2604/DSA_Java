import java.util.*;

public class CycleDetectionInDirectedGraph {

    private boolean dfsCycleDetect(List<List<Integer>>adjList, boolean[] visited, boolean[] dfs, int node){
        visited[node]=true;
        dfs[node]=true;

        for(int i=0;i<adjList.get(node).size();i++){
            int neigbour=adjList.get(node).get(i);
            if( !visited[neigbour] ){
                dfsCycleDetect(adjList, visited, dfs, neigbour);  
            }
            else if(dfs[neigbour]){
                return true;
            }
        }
        
        dfs[node]=false;
        return false;
    }

    public boolean detectCycle(int nodes, int[][] edge){
        List<List<Integer>>adjList=new ArrayList<>(nodes);
        boolean[] visited=new boolean[nodes];
        boolean[] dfs=new boolean[nodes];

        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edge.length;i++){
            int u=edge[i][0];
            int v=edge[i][1];

            adjList.get(u).add(v);
        }

        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                boolean isCycle=dfsCycleDetect(adjList, visited, dfs, i);
                if(isCycle){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes");
        int nodes=sc.nextInt();
        System.out.println("Enter the no. of  directed edges");
        int edges=sc.nextInt();
        System.out.println("Enter the directed edges");
        int[][] edge=new int[edges][2];
        for(int i=0;i<edges;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }
        CycleDetectionInDirectedGraph cycle=new CycleDetectionInDirectedGraph();
        boolean ans=cycle.detectCycle(nodes, edge);
        System.out.println(ans);
    }
}
