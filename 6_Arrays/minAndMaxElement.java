import java.util.*;
public class minAndMaxElement {

    public static int minElement(int arr[],int size){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    public static int maxElement(int arr[],int size){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public static int[] minAndMax(int arr[],int size){
        int ans[]=new int[2];
        ans[0]=minElement(arr, size);
        ans[1]=maxElement(arr, size);
        return ans;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array");
        int size=sc.nextInt();
        System.out.println("Enter the numbers to find the minimum and maximum element");
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

        int ans[]=minAndMax(arr, size);
        System.out.println("The minimum element is "+ans[0]);
        System.out.println("The maximum element is "+ans[1]);

    }
}
