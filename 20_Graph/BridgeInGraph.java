import java.util.*;

public class BridgeInGraph {

    private void dfs(int node, int parent, int[] timer, int[] discoveryTime, int[] lowestTime, boolean[] visited, List<List<Integer>>adjList, List<List<Integer>>ans){
        visited[node]=true;
        timer[0]++;
        discoveryTime[node] = timer[0];
        lowestTime[node] = timer[0];

        List<Integer>neigbours=adjList.get(node);
        for(int neigbour: neigbours){
            if(neigbour == parent){
                continue;
            }
            else if(!visited[neigbour]){
                dfs(neigbour, node, timer, discoveryTime, lowestTime, visited, adjList, ans);
                lowestTime[node] = Math.min( lowestTime[node], lowestTime[neigbour]);

                // i.e. there is only one way to reach neigbour and i.e. from its parent(node)
                // because of that the lowestTime[neigbour] will be greater than its parent i.e. lowestTime[node]
                if(lowestTime[neigbour] > discoveryTime[node]){
                    List<Integer>list=new ArrayList<>();
                    list.add(node);
                    list.add(neigbour);
                    ans.add(list);
                }
            }
            else{
                // back edge is present
                lowestTime[node] = Math.min(lowestTime[node], discoveryTime[neigbour]);
            }
        }
    }


    public List<List<Integer>> bridgeInGraph(int nodes, int[][] edge){
        List<List<Integer>>ans=new ArrayList<>();

        // Step 1: Create adjList
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edge.length;i++){
            int u=edge[i][0];
            int v=edge[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println("AdjList is");
        displayList(adjList);


        // Step 2: Use data structures for discovery time, lowest time, parent, visited
        int[] timer={0};
        int parent=-1;
        int[] discoveryTime=new int[nodes];
        int[] lowestTime=new int[nodes];
        boolean[] visited=new boolean[nodes];

        for(int i=0;i<nodes;i++){
            discoveryTime[i]=-1;
            lowestTime[i]=-1;
            visited[i]=false;
        }


        // Step 3: Perform dfs and find bridge
        for(int i=0;i<nodes;i++){
            if(!visited[i])
                dfs(i, parent, timer, discoveryTime, lowestTime, visited, adjList, ans);
        }

        return ans;
    }

    public void displayList(List<List<Integer>>list){
        for(List<Integer>child: list){
            for(int element:child){
                System.out.print(element+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes");
        int nodes=sc.nextInt();
        System.out.println("Enter the no. of edges");
        int edges=sc.nextInt();

        System.out.println("Enter the nodes connected with edges");
        int[][] edge=new int[edges][2];

        for(int i=0;i<edges;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }
        
        BridgeInGraph bridge= new BridgeInGraph();
        List<List<Integer>>ans = bridge.bridgeInGraph(nodes, edge);
        System.out.println("Bridge is present in between nodes as follows");
        bridge.displayList(ans);
    }
}
