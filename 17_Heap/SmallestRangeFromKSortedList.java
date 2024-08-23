import java.util.*;

public class SmallestRangeFromKSortedList {
    class Node{
        int value;
        int row;
        int col;

        Node(int value, int row, int col){
            this.value=value;
            this.row=row;
            this.col=col;
        }
    }

    Comparator<Node> compare = new Comparator<Node>(){
        public int compare(Node n1, Node n2){
            return Integer.compare(n1.value, n2.value);
        }
    };

    public int smallestRangeFromKSortedList( List<List<Integer>>KArrays){
        PriorityQueue<Node>pq=new PriorityQueue<Node>(compare);

        // Step 1: Add k elements into min. heap
        // find mini and maxi
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<KArrays.size();i++){
            mini=Math.min(mini,KArrays.get(i).get(0));
            maxi=Math.max(maxi,KArrays.get(i).get(0));
            pq.add(new Node(KArrays.get(i).get(0), i, 0));
        }

        int start=mini, end=maxi;

        while(!pq.isEmpty()){
            Node temp=pq.remove();
            mini=temp.value;

            if(maxi-mini < end-start){
                start=mini;
                end=maxi;
            }

            if(temp.col + 1 < KArrays.get(0).size() ){
                maxi=Math.max(maxi,KArrays.get(temp.row).get(temp.col + 1));
                pq.add(new Node(KArrays.get(temp.row).get(temp.col + 1), temp.row, temp.col+1));
            }
            else{
                break;
            }
        }
        return end-start+1;
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of k");
        int k=sc.nextInt();
        List<List<Integer>>KArrays=new ArrayList<>();

        System.out.println("Enter data(sorted manner) into each array to add data into next array enter -1");
        for(int i=0;i<k;i++){
            List<Integer>list=new ArrayList<>();
            int data=sc.nextInt();
            while(data!=-1){
                list.add(data);
                data=sc.nextInt();
            }

            KArrays.add(list);
        }

        for(int i=0;i<k;i++){
            System.out.println(KArrays.get(i));
            System.out.println("----------------------------");
        }

        SmallestRangeFromKSortedList mksa=new SmallestRangeFromKSortedList();
        int ans=mksa.smallestRangeFromKSortedList(KArrays);

        System.out.println(ans);
        System.out.println();
    }
}
