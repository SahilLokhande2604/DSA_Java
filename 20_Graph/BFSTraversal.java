import java.util.*;

public class BFSTraversal {

    private void bfs(List<List<Integer>>adjList, int node, List<Integer>ans, boolean[] visited){
        Queue<Integer>q=new LinkedList<>();

        q.add(node);
        visited[node]=true;

        while(!q.isEmpty()){
            node=q.remove();
            ans.add(node);

            for(int i=0;i<adjList.get(node).size();i++){
                int neigbour=adjList.get(node).get(i);
                if(!visited[neigbour]){
                    q.add(neigbour);
                    visited[neigbour]=true;
                }
            }
        }
    }

    public List<Integer> bfsTraversal(int nodes, int[][] edge){
        List<Integer>ans=new ArrayList<>();
        boolean[] visited=new boolean[nodes];

        // create adjList
        List<List<Integer>>adjList=new ArrayList<>(nodes);

        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edge.length;i++){
            int u=edge[i][0];
            int v=edge[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // as graph can be disjoint graph so check whether each node is visited or not
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                bfs(adjList, i, ans, visited);
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

        BFSTraversal bfs=new BFSTraversal();
        List<Integer>ans = bfs.bfsTraversal(nodes,edge);
        System.out.println(ans);


    }
}
