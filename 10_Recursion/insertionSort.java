import java.util.Scanner;

public class insertionSort {

    public static void insertion_Sort(int arr[],int start,int end,int n){
        if(start>end){
            return;
        }
        int currentVal=arr[start];
        int j=start-1;
        for(;j>=0;j--){
            if(arr[j]>currentVal){
                arr[j+1]=arr[j];
            }
            else{
                break;
            }
        }
        arr[j+1]=currentVal;
        // display(arr);

        insertion_Sort(arr, start+1, end, n);

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
        insertion_Sort(arr, 1,arr.length-1,size);
        display(arr);
    }
}
