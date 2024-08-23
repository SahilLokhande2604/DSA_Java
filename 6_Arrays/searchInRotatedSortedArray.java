import java.util.Scanner;

public class searchInRotatedSortedArray {

    public static int pivot(int arr[]){
        int start=0;
        int end=arr.length-1;
        int mid=start+((end-start)/2);
        while(start<end){
            if(arr[mid]>=arr[0]){
                start=mid+1;
            }
            else{
                end=mid;
            }
            mid=start+((end-start)/2);
        }
        return start;
    }
    public static int searchForIndex(int arr[],int key){
        int start=0;
        int end=arr.length-1;
        
        int pivot=pivot(arr);
        if(key>=arr[pivot] && key<=arr[arr.length-1]){
            start=pivot;
        }
        else{
            end=pivot-1;
        }
        int mid=start+((end-start)/2);
        while(start<=end){
            if(key==arr[mid]){
                return mid;
            }
            else if(key<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            mid=start+((end-start)/2);
        }
        return -1;
    }
     public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int size;
            System.out.println("Enter the size of the array");
            size=sc.nextInt();
            int arr[]=new int[size];
            System.out.println("Enter the elements to the array in ascending order with rotation");
            System.out.println("e.x [5,6,7,1,2,3,4]");
            for(int i=0;i<size;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println("Enter the key to find in the array");
            int key=sc.nextInt();
            int ans=searchForIndex(arr,key);
            System.out.println("The index of key is "+ans);
        }
}
