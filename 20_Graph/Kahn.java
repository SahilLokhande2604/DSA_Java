import java.util.*;

public class Kahn {

    public void kahnTopologicalSort(int nodes, int edges, int[][] edge){
        List<List<Integer>>adjList=new ArrayList<>(nodes);
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            adjList.get(u).add(v);
        }

        int[] inDegree=new int[nodes];
        for(int i=0;i<edges;i++){
            inDegree[edge[i][1]]++;
        }

        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        
        List<Integer>ans=new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.poll();
            ans.add(node);

            for(int neigbour: adjList.get(node)){
                inDegree[neigbour]--;
                if(inDegree[neigbour]==0){
                    queue.add(neigbour);
                }
            }

        }

        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }


    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes");
        int nodes=sc.nextInt();
        System.out.println("Enter the no. of edges");
        int edges=sc.nextInt();

        int[][] edge=new int[edges][2];

        System.out.println("Enter the nodes which has edges between them directed edges e.g. u->v");
        for(int i=0;i<edges;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }

        Kahn k=new Kahn();
        k.kahnTopologicalSort(nodes,edges,edge);
    }
}
