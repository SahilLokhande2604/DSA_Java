import java.util.*;
public class Heapify {

    private void heapify(int[] arr, int n, int index){
        int parentIndex=index;
        int leftChildIndex=parentIndex*2;
        int rightChildIndex=parentIndex*2 + 1;

        if(leftChildIndex<=n && arr[parentIndex]<arr[leftChildIndex]){
            parentIndex=leftChildIndex;
        }
        if(rightChildIndex<=n && arr[parentIndex]<arr[rightChildIndex]){
            parentIndex=rightChildIndex;
        }
        if(parentIndex!=index){
            // swap
            int temp=arr[index];
            arr[index]=arr[parentIndex];
            arr[parentIndex]=temp;

            heapify(arr, n, parentIndex);
        }
    }

    public void maxHeap(int[] arr){
        int n=arr.length-1;
        for(int i=n/2;i>0;i--){
            heapify(arr,n,i);
        }
    }

    public void display(int[] arr, int size){
        System.out.println("Heap is");
        for(int i=1;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of heap");
        int size=sc.nextInt();
        System.out.println("Enter data into the heap");
        int[] arr=new int[size+1];
        for(int i=1;i<=size;i++){
            arr[i]=sc.nextInt();
        }

        Heapify hfy = new Heapify();

        hfy.maxHeap(arr);

        hfy.display(arr,size);




    }
}
