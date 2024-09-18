import java.util.*;
public class Dijkstra {

    private class Pair{
        int distance;
        int node;

        Pair(int node, int distance){
            this.distance=distance;
            this.node=node;
        }
    }

    Comparator<Pair>compare=new Comparator<Pair>(){
        public int compare(Pair p1, Pair p2){
            return Integer.compare(p1.distance, p2.distance);
        }
    };

    

    public void dijkstra(int nodes, int edges, int[][] edge, int src){
        // create adjList
        List<List<Pair>>adjList=new ArrayList<>(nodes);
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            int w=edge[i][2];

            adjList.get(u).add(new Pair(v,w));
            adjList.get(v).add(new Pair(u,w));
        }

        // create a distance array
        int[] distance = new int[nodes];
        for(int i=0;i<nodes;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;

        PriorityQueue<Pair>pq=new PriorityQueue<>(compare);
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair top=pq.remove();
            
            for(Pair p: adjList.get(top.node)){
                if(top.distance + p.distance < distance[p.node]){
                    if(pq.contains(p)){
                        pq.remove(p);
                    }
                    distance[p.node] = top.distance + p.distance;
                    pq.add(new Pair(p.node, distance[p.node]));
                }
            }
        }

        System.out.println("Distance array is");
        for(int i=0;i<distance.length;i++){
            System.out.print(distance[i]+" ");
        }

    }
    
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes");
        int nodes=sc.nextInt();
        System.out.println("Enter the no. of edges");
        int edges=sc.nextInt();
        System.out.println("Enter the pair of nodes connected along with edge weight");
        int[][] edge=new int[edges][3];
        for(int i=0;i<edges;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
            edge[i][2]=sc.nextInt();
        }

        Dijkstra d=new Dijkstra();
        System.out.println("Enter the source node");
        int src=sc.nextInt();
        d.dijkstra(nodes, edges, edge, src);
    }
}
