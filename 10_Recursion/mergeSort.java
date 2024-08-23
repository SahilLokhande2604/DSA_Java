import java.util.Scanner;

public class mergeSort {

    public static void merge_Sort(int arr[],int start,int end,int n){
       
        if(start>=end){
            return;
        }

        int mid=start+((end-start)/2);
     
        merge_Sort(arr, start, mid, n);
    
        merge_Sort(arr, mid+1, end, n);
     

        merge(arr,start,end);


    }

    public static void merge(int arr[],int start,int end){
        int mid=start+((end-start)/2);
        int arr1[]=new int[mid-start+1];
        int arr2[]=new int[end-mid];

        int mainArrayIndex=start;
        for(int i=0;i<arr1.length;i++){
            arr1[i]=arr[mainArrayIndex++];
        }
        mainArrayIndex=mid+1;
        for(int i=0;i<arr2.length;i++){
            arr2[i]=arr[mainArrayIndex++];
        }

        mainArrayIndex=start;
        int index1=0,index2=0;

        while(index1<arr1.length && index2<arr2.length){
            if(arr1[index1]<arr2[index2]){
                arr[mainArrayIndex++]=arr1[index1++];
            }
            else{
                arr[mainArrayIndex++]=arr2[index2++];
            }
        }

        while(index1<arr1.length){
            arr[mainArrayIndex++]=arr1[index1++];
        }

        while(index2<arr2.length){
            arr[mainArrayIndex++]=arr2[index2++];
        }
        // System.out.println("start="+start+" end="+end);
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
        merge_Sort(arr, 0,arr.length-1,size);
        // display(arr,0,arr.length-1);
    }
}



// 4 12 3 1 16 20 9 

// size= 7