import java.util.Scanner;

public class bubbleSort {

    public static void sortByBubble(int arr[],int n){
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;    
                }
                count++;
                    System.out.println("swap count="+count);
                display(arr, n);
            }
        }
    }

    public static void sortByBubbleOptimize(int arr[],int n){
        int count=0;
        for(int i=0;i<n-1;i++){
            // flag = true denotes that swapping is done
            boolean flag=false;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
                count++;
                    System.out.println("swap count="+count);
                display(arr, n);
                    
            }
            if(flag==false){
                break;
                // no swapping is done which means that array is already sorted
            }
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
        sortByBubble(arr,n);
        System.out.println("The array after sorting is ");
        display(arr, n);

        System.out.println("The array while optimize sorting is ");
        sortByBubbleOptimize(arr2,n);
        System.out.println("The array after optimize sorting is ");
        display(arr2, n);


    }
}
