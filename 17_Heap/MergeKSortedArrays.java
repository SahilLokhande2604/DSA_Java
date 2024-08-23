import java.util.*;
public class MergeKSortedArrays {

    private class Info{
        int data;
        int arrayNo;
        int index;

        Info(int data, int arrayNo, int index){
            this.data=data;
            this.arrayNo=arrayNo;
            this.index=index;
        }
    }

    Comparator<Info> comparator = new Comparator<Info>() {
        @Override
        public int compare(Info o1, Info o2) {
            return Integer.compare(o1.data, o2.data);
        }
    };

    public int[] mergeKSortedArray(List<List<Integer>>KArrays){

        PriorityQueue<Info>pq=new PriorityQueue<>(comparator);
        List<Integer>ans=new ArrayList<>();
        int k=KArrays.size();
        // Step 1: Insert 0th index data of each array into pq(min. heap)
        // need to insert data along with additional info like the array no. and the index of data
        for(int i=0;i<k;i++){
            Info info=new Info(KArrays.get(i).get(0),i,0);
            pq.add(info);
        }

        
        // Step 2: Remove the top data from pq and add into ans and add next index's data from the array whose element was at top into pq if present
        // Step 3: Repeat Step 2 till pq is not empty
        while(!pq.isEmpty()){
            Info top=pq.remove();
            ans.add(top.data);
            int arrayNo=top.arrayNo;
            int index=top.index;

            if(index+1 < KArrays.get(arrayNo).size()){
                Info info=new Info(KArrays.get(arrayNo).get(index+1),arrayNo,index+1);
                pq.add(info);
            }
        }


        int[] arr=new int[ans.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=ans.get(i);
        }

        return arr;  
    }
    public static void main(String[] args) {
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

        MergeKSortedArrays mksa=new MergeKSortedArrays();
        int[] ans=mksa.mergeKSortedArray(KArrays);

        System.out.println("Array after merging K sorted arrays is ");
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}
