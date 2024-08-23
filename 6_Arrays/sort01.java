import java.util.Scanner;

public class sort01 {
    public static void displaySorted01(int arr[]){
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }

    // using 2 pointers
    //Time Comlexity O(n^2)
    public static void sort0and1(int arr[]){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            while((arr[left]==0) && left<right){
                left++;
            }
            while((arr[right]==1) && left<right){
                right--;
            }
            if((arr[left]==1 && arr[right]==0) && left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
            
        }
        displaySorted01(arr);
    }
     public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int size;
        System.out.println("Enter the size of the array");
        size=sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter the elements to the array");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        sort0and1(arr);

    }
}
