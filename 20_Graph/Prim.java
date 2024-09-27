import java.util.*;

public class Prim {

    private class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public void mstUsingPrim(int nodes, int edges, int[][] edge) {
        // create adjList
        List<List<Pair>> adjList = new ArrayList<>(nodes);

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            int w = edge[i][2];
            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }

        // create 2 data structures
        // key[] to store distances/weights of edges included in mst
        // mst[] to store the nodes included in mst
        // parent[] to store parent of each node
        int[] key = new int[nodes];
        boolean[] mst = new boolean[nodes];
        int[] parent = new int[nodes];

        // initially mark all distance as infinity
        // all nodes are out of mst so mark then false
        // initially we dont know parent of each nodes so mark then -1
        for (int i = 0; i < nodes; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }

        // start from source node let src node is 0
        key[0] = 0;
        parent[0] = -1;

        for (int node = 0; node < nodes; node++) {
            // step 1: find min. value from key such that it should be min in key and its
            // mst n=must be false
            int mini = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < nodes; i++) {
                if (mini > key[i] && !mst[i]) {
                    mini = key[i];
                    index = i;
                }
            }
            if (index != -1) {
                // step 2: mark the current node mst[]=true
                mst[index] = true;

                // step 3: find all its neigbour and update their distance
                for (Pair neigbour : adjList.get(index)) {
                    int nodeVal = neigbour.node;
                    int weight = neigbour.weight;
                    if (key[nodeVal] > weight) {
                        key[nodeVal] = weight;
                        parent[nodeVal] = index;
                    }
                }
            }
        }

        System.out.println("child  parent");
        for(int i=0;i<nodes;i++){
            System.out.println(i+"->"+parent[i]);
        }
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
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

        Prim p = new Prim();
        p.mstUsingPrim(nodes, edges, edge);
    }
}