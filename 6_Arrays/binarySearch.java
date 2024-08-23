import java.util.*;
public class binarySearch {

    public static int binary(int arr[],int key){
        int s=0;
        int e=arr.length-1;
        int mid=(s+e)/2;
        while(s<=e){
            if(arr[mid]==key){
                return mid;
            }
            else if(key>arr[mid]){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
            mid=(s+e)/2;
        }

        return -1;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int size;
        System.out.println("Enter the size of the array");
        size=sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter the elements to the array in ascending order");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the key to find in the array");
        int key=sc.nextInt();

        int index=binary(arr, key);
        System.out.println("The key is present at index "+index);

    }
}
