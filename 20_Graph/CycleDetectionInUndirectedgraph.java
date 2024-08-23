import java.util.*;
public class CycleDetectionInUndirectedgraph {

    private boolean bfsCycleDetection(int node, List<List<Integer>>adjList, boolean[] visited, Map<Integer,Integer>parent){
        Queue<Integer>q=new LinkedList<>();
        q.add(node);
        visited[node]=true;
        parent.put(node,-1);
        while(!q.isEmpty()){
            node=q.remove();
            for(int i=0;i<adjList.get(node).size();i++){
                int neigbour=adjList.get(node).get(i);
                if(!visited[neigbour]){
                    q.add(neigbour);
                    parent.put(neigbour,node);
                    visited[neigbour]=true;
                }
                else if(visited[neigbour] && parent.get(neigbour)!=node){
                    return true;
                }

            }
        }
        return false;
    }

    private boolean dfsCycleDetection(int node, int parent, List<List<Integer>>adjList, boolean[] visited){
        visited[node]=true;
        for(int i=0;i<adjList.get(node).size();i++){
            int neigbour=adjList.get(node).get(i);
            if(!visited[neigbour]){
                dfsCycleDetection(neigbour, node, adjList, visited);
            }
            else if(neigbour!=parent){
                return true;
            }
        }
        return false;
    }

    public boolean CycleDetection(int nodes, int[][] edge){
        List<List<Integer>>adjList=new ArrayList<>(nodes);
        boolean[] visited=new boolean[nodes];
        boolean ans=false;


        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edge.length;i++){
            int u=edge[i][0];
            int v=edge[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Map<Integer,Integer>parent=new HashMap<>();

        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                // ans=bfsCycleDetection(i, adjList, visited, parent);
                ans=dfsCycleDetection(i, -1, adjList, visited);
                if(ans=true){
                    return ans;
                }
            }
        }
        return ans;
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes");
        int nodes=sc.nextInt();
        System.out.println("Enter the no. of edges");
        int edges=sc.nextInt();
        int[][] edge=new int[edges][2];
        System.out.println("Enter the nodes which are connected with edges in pair");
        for(int i=0;i<edges;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }

        CycleDetectionInUndirectedgraph cycle=new CycleDetectionInUndirectedgraph();
        boolean ans = cycle.CycleDetection(nodes,edge);
        System.out.println(ans);

    }
}
