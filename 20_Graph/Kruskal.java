import java.util.*;
public class Kruskal {

    private int findParent(int[] parent, int node){
        // base case when node's parent is node itself
        if(parent[node]==node){
            return node;
        }
        // parent[node]=findParent(parent,parent[node]) -> use for path compression
        return parent[node]=findParent(parent, parent[node]);
    }

    private void unionSet(int u, int v, int[] parent, int[] rank){
        // find parent
        u=findParent(parent, u);
        v=findParent(parent, v);
        // get rank and comapre
        if(rank[u]>rank[v]){
            parent[v]=u;
        }
        else if(rank[u]<rank[v]){
            parent[u]=v;
        }
        else{
            parent[u]=v;
            rank[v]++;
        }

    } 
   
    
    public int kruskalAlgo(int nodes, int edges,int[][] edge){
        // sort the edge base on the weight
        Arrays.sort(edge, (a,b)->{
            return Integer.compare(a[2], b[2]);
        });


        int[] rank=new int[nodes];
        int[] parent=new int[nodes];
        // initially rank of each node is 0
        // parent of each node is itself
        for(int i=0;i<nodes;i++){
            rank[i]=0;
            parent[i]=i;
        }

        int cost=0;

        for(int i=0;i<edge.length;i++){
            int u=findParent(parent, edge[i][0]);
            int v=findParent(parent, edge[i][1]);
            int w=edge[i][2];

            if(u!=v){
                cost+=w;
                unionSet(u,v,parent,rank);
            }
        }
        
        return cost;
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes");
        int nodes = sc.nextInt();
        System.out.println("Enter the no. of edges");
        int edges = sc.nextInt();

        System.out.println("Enter the pair of nodes conneted with edge weights");
        int[][] edge = new int[edges][3];

        for (int i = 0; i < edges; i++) {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
            edge[i][2] = sc.nextInt();
        }

        Kruskal k =new Kruskal();
        System.out.println(k.kruskalAlgo(nodes, edges, edge));
    }
}


// Enter the no. of nodes
// 6
// Enter the no. of edges
// 9
// Enter the pair of nodes conneted with edge weights
// 0 1 2
// 0 3 1
// 0 4 4
// 1 2 3
// 1 3 3
// 1 5 7
// 2 3 5
// 2 5 8
// 3 4 9
// 17