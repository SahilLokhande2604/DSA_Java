// Remain to complete

import java.util.Scanner;

public class mergeSortFast {

    public static void mergeSort(int arr[],int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+((end-start)/2);

        mergeSort(arr, start, mid);

        mergeSort(arr, mid+1, end);

        merge(arr,start,end);
    }

    public static void merge(int arr[],int start,int end){
        int mid=start+((end-start)/2);

        int len1=mid-start+1;
        int len2=end-mid;

        int index1=0,index2=mid+1;

        while(index1<len1 && index2<=end){
           int current=arr[index1];
           int minIndex=index1;
           for(int i=index2;i<=end;i++){
            if(arr[i]<current){
                minIndex=i;
            }
           }
           int temp=current;
           arr[index1]=arr[minIndex];
           arr[minIndex]=temp;
           

        }

        display(arr, start, end);
    }


    public static void display(int arr[],int start,int end){
        for(int i=0;i<=end;i++){
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
        display(arr,0,arr.length-1);
        mergeSort(arr, 0,arr.length-1);
        // display(arr,0,arr.length-1);
    }
}
