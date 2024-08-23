import java.util.*;
public class selectionSort{

    public static void sortBySelection(int arr[],int n){
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<=arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
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
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("The array is ");
        display(arr, n);
        System.out.println("The array while sorting is ");
        sortBySelection(arr,n);
        System.out.println("The array after sorting is ");
        display(arr, n);
    }
}