import java.util.Scanner;

public class merge2SortedArrays {

    public static void merge(int arr1[],int n,int arr2[],int m){
        int arr3[]=new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                arr3[k]=arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k]=arr2[j];
                k++;
                j++;
            }
        }
        while(i<n){
            arr3[k]=arr1[i];
            k++;
            i++;
        }
        while(j<m){
            arr3[k]=arr2[j];
            k++;
            j++;
        }
        display(arr3, n+m);
    }


    public static void display(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of 1st array");
        int n=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr1[]=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }

        System.out.println("Enter the size of 2nd array");
        int m=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr2[]=new int[m];
        for(int i=0;i<m;i++){
            arr2[i]=sc.nextInt();
        }
        System.out.println("The array is ");
        display(arr1, n);
        display(arr2, m);

        System.out.println("The array after merging is ");
        merge(arr1,n,arr2,m);
}
}
