import java.util.Scanner;

public class isSorted {

    public static boolean isSortedOrNot(int arr[],int size,int index){
        if(index==size-1){
            return true;
        }
        if(arr[index]>arr[index+1]){
            return false;
        }
        
        return isSortedOrNot(arr, size,++index);
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

        boolean flag=isSortedOrNot(arr,size,0);
        System.out.println("The array is sorted. "+flag);

    }
}
