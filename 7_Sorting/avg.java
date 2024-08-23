import java.util.*;
public class avg {
    public static void average(long[] arr){
        long count=arr.length;
        long sum=0;
        for(int i=0;i<count;i++){
            sum=sum+arr[i];
        }
        System.out.println("avg="+(sum/count));

    }
    public static void display(long arr[],int n){
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
        long arr[]=new long[n];
        long arr2[]=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        System.out.println("The array is ");
        display(arr, n);
        average(arr);
    }
}
