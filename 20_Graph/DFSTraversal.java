import java.util.*;
public class DFSTraversal {

    private void dfs(List<List<Integer>>adjList, int node, List<Integer>ans, boolean[] visited){
        // Stack<Integer> stack=new Stack<>();
        // stack.push(node);
        // visited[node]=true;
        // while(!stack.isEmpty()){
        //     node=stack.pop();
        //     ans.add(node);
        //     for(int i=0;i<adjList.get(node).size();i++){
        //         int neigbour=adjList.get(node).get(i);
        //         if(!visited[neigbour]){
        //             stack.push(neigbour);
        //             visited[neigbour]=true;
        //         }
        //     }
        // }

        // recursive function
        ans.add(node);
        visited[node]=true;

        for(int i=0;i<adjList.get(node).size();i++){
            int neigbour=adjList.get(node).get(i);
            if(!visited[neigbour]){
                dfs(adjList, neigbour, ans, visited);
            }
        }
    }

    public List<Integer> dfsTraversal(int nodes, int[][] edge){
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

        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                dfs(adjList, i, ans, visited);
            }
        }

        return ans;
    }
    public static void main(String a[]){

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

        DFSTraversal dfs=new DFSTraversal();
        List<Integer>ans = dfs.dfsTraversal(nodes,edge);
        System.out.println(ans);
    }
}
