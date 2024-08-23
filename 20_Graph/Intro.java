import java.util.*;

public class Intro{

    public void createGraph(int nodes, int edges, int[][] connections){
        int[][] adjMatrix=new int[nodes][nodes];

        for(int i=0;i<edges;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            adjMatrix[u][v]=1;
            adjMatrix[v][u]=1;
        }

        displayAdjancencyMatrix(adjMatrix);

        List<List<Integer>>adjList=new ArrayList<>(nodes);

        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        displayAdjancencyList(adjList);

        
    }

   

    private void displayAdjancencyMatrix(int[][] adjMatrix){
        for(int i=0;i<adjMatrix.length;i++){
            for(int j=0;j<adjMatrix[0].length;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void displayAdjancencyList(List<List<Integer>>adjList){
        for(int i=0;i<adjList.size();i++){
            System.out.print(i+"->");
            System.out.println(adjList.get(i));
        }
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of nodes");
        int n=sc.nextInt();
        System.out.println("Enter the no. of edges");
        int m=sc.nextInt();

        int[][] arr=new int[m][2];
        System.out.println("Enter the pair of nodes connected to each other (nodes are between 0 to n-1 inclusive)");
        for(int i=0;i<m;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        Intro graph =new Intro();
        graph.createGraph(n,m,arr);
        
    }
}