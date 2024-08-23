// Given an array of size N which contains numbers from 1 to n-1 and one number has occur twice so find that number
//e.x. array={3,2 9,4,2,1,6,7,5,8}
//answer is 2 as it occurce twice 
import java.util.*;
public class duplicate {
    public static void display(int arr[], int size) {
        System.out.println();
        for (int i = 0; i < size; i++) {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println();
     
    }

    public static int findDuplicate(int arr[],int size){
        int duplicate=0;
        for(int i=0;i<size;i++){
            duplicate=duplicate+arr[i];
        }
        int sumOfNaturalNumbers=((size-1)*((size-1)+1))/2;
        System.out.println(sumOfNaturalNumbers+" "+duplicate);
        
        duplicate=duplicate-sumOfNaturalNumbers;
        
        return Math.abs(duplicate);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array it must be even");
        int size=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("The array is");
        display(arr,size);

        int ans=findDuplicate(arr, size);
        System.out.println("The duplicate element is "+ans);
    }
}
