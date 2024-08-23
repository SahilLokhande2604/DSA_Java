import java.util.Scanner;

public class selectionSort {
    public static void selection_Sort(int arr[],int start,int end,int n){
        if(start==end){
            return;
        }
        
        int minIndex=start;
        for(int i=start+1;i<n;i++){
            if(arr[minIndex]>arr[i]){
                minIndex=i;
            }
        }
        int temp=arr[minIndex];
        arr[minIndex]=arr[start];
        arr[start]=temp;

        selection_Sort(arr, start+1, end, n);
    }

    public static void display(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size");
        int size=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        display(arr);
        selection_Sort(arr, 0,arr.length-1,size);
        display(arr);
    }
}
