import java.util.Scanner;

public class binarySearch {

    public static boolean searchUsingBinarySearch(int arr[],int start,int end,int key){
        int mid=start+(end-start)/2;
        if(arr.length==0){
            return false;
        }
        if(start>end){
            return false;
        }
        if(arr[mid]==key){
            return true;
        }
        if(arr[mid]<key){
            return searchUsingBinarySearch(arr,mid+1,end,key);
        }
        else{
            return searchUsingBinarySearch(arr,start,mid-1,key);
        }

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
        System.out.println("Enter the key to search in the array ");
        int key=sc.nextInt();
        boolean flag=searchUsingBinarySearch(arr, 0, arr.length-1, key);
        System.out.println("The key "+key+" is present in array "+flag);
    }
}
