import java.util.*;
public class reverseArray {

    public static void display(int arr[], int size) {
        
        for (int i = 0; i < size; i++) {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println();
     
    }

    public static int[] reverse(int arr[],int size){
        int j=size-1;
        for(int i=0;i<(size/2);i++){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;
        }
        return arr;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("The array before reversing is");
        display(arr,size);
        System.out.println("The array after reversing is");
        reverse(arr, size);
        display(arr,size);

    }
}
