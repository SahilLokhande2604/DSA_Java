import java.util.*;
public class MergeTwoMaxHeap {

    private void heapify(int[] heap, int n, int index){
        int parentIndex=index;
        int leftChildIndex=parentIndex*2 + 1;
        int rightChildIndex=parentIndex*2 + 2;

        if(leftChildIndex<n && heap[leftChildIndex]>heap[parentIndex]){
            parentIndex=leftChildIndex;
        }
        if(rightChildIndex<n && heap[rightChildIndex]>heap[parentIndex]){
            parentIndex=rightChildIndex;
        }
        if(parentIndex!=index){
            // swap
            int temp=heap[index];
            heap[index]=heap[parentIndex];
            heap[parentIndex]=temp;

            heapify(heap, n, parentIndex);
        }
    }

    public int[] mergeHeap(int[] heap1, int[] heap2){
        int size=heap1.length + heap2.length;

        int[] heap=new int[size];

        int index=0;
        for(int i:heap1){
            heap[index++]=i;
        }
        for(int i:heap2){
            heap[index++]=i;
        }

        for(int i=size/2 -1; i>=0;i--){
            heapify(heap,size,i);
        }
        return heap;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of first max. heap");
        int size1=sc.nextInt();
        System.out.println("Enter data into 1st max. heap");
        int[] heap1=new int[size1];
        for(int i=0;i<size1;i++){
            heap1[i]=sc.nextInt();
        }

        System.out.println("Enter size of second max. heap");
        int size2=sc.nextInt();
        System.out.println("Enter data into 2st max. heap");
        int[] heap2=new int[size2];
        for(int i=0;i<size2;i++){
            heap2[i]=sc.nextInt();
        }

        MergeTwoMaxHeap mmh = new MergeTwoMaxHeap();
        int[] heap=mmh.mergeHeap(heap1,heap2);

        for(int i=0;i<heap.length;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
}

// heap1 10 5 6 2
// heap2 12 7 9


// merged heap is 12 10 9 2 5 7 6 