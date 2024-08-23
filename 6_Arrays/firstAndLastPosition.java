import java.util.*;

public class firstAndLastPosition {

    public static int[] findFirstAndLastOccuranceOFElement(int arr[],int element){
        int ans[]=new int[2];

        int start=0,end=arr.length-1;
        int tempStart=-1;
        while(start<=end){
            int mid=start + ((end-start)/2);
            if(arr[mid]==element){
                tempStart=mid;
                end=mid-1;
            }
            else if(element>arr[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        start=tempStart;
        end=arr.length-1;
        int tempEnd=-1;
        while(start<=end){
            int mid=start+((end-start)/2);
            if(arr[mid]==element){
                start=mid+1;
                tempEnd=mid;
            }
            else if(element>arr[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        ans[0]=tempStart;
        ans[1]=tempEnd;


        return ans;
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

        int ans[]=findFirstAndLastOccuranceOFElement(arr, key);
        // for(int i=0;i<ans.length;i++){
            System.out.println("First occurance is at index "+ans[0]);
            System.out.println("Last occurance is at index "+ans[1]);
        // }
    }
}
