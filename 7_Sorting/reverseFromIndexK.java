import java.util.Scanner;

public class reverseFromIndexK {

    public static void reverse(int arr[],int n,int k){
         int start=k+1;
         int end=n-1;
         while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
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
        System.out.println("Enter the index after which you want to reverse the array ");
        int k=sc.nextInt();
        reverse(arr,n,k);
        System.out.println("The array after reversing is ");
        display(arr, n);
}
}
