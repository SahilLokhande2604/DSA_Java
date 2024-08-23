// Pivot in an array is the index of the smallest element in the rotated sorted array
// i.e if initial array is [1,2,3,4,5,6,7] and after rotation it becomes
//  [5,6,7,1,2,3,4] now here the pivot element is 1 and its index is 3 
// in some questions the largest element is called as pivot element 
// so with same example for this case pivot element will be 7 with index 2

import java.util.*;
public class pivot {

    public static int findPivotIndex(int arr[]){
        int start=0;
        int end=arr.length;
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

            int ans=findPivotIndex(arr);
            System.out.println("The pivot index is "+ans);
        }
}

//  [0,1,2,3,4,5,6,7,8,9,10] 
//  [5,6,7,1,2,2,2,2,3,3,3] 
// with above example start=0,end=10,mid=5
// now as arr[mid]=arr[5]=2
// thus we know that if arr[mid] will be always greater than arr[0] till it reaches to the highest element 
// so we need to search ahead of the mid so start will become start=mid+1
// now here start=6,end=9,mid=7
// now arr[mid]=arr[7]=2 which is less than arr[0] 
// which means that we are now in the range which is from pivot element to element which is less than arr[0]
// thus in this case we need to update the end as end=mid as our pivot lies behind or at the current index
// in such way we need to iterate till start<end and when condition becomes false we will get our pivot index as start==end==mid