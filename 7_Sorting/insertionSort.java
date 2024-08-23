import java.util.Scanner;

public class insertionSort {

    public static void sortByInsertion(int arr[],int n){
        for(int i=1;i<n;i++){
            int temp=arr[i];
            int j=i-1;
            for(;j>=0;j--){
                if(arr[j]>temp){
                    arr[j+1]=arr[j];
                }
                else{
                    break;
                }
                display(arr, n);
            }
            arr[j+1]=temp;
            display(arr, n);
        }
    }


    public static void display(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr[]=new int[n];
        int arr2[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            arr2[i]=arr[i];
        }
        System.out.println("The array is ");
        display(arr, n);
        System.out.println("The array while sorting is ");
        sortByInsertion(arr,n);
        System.out.println("The array after sorting is ");
        display(arr, n);


    }
}
