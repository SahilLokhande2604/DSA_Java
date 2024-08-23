import java.util.*;

public class scopeOfArray {

    public static void display(int arr[], int size) {
        
        for (int i = 0; i < size; i++) {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println();
     
    }
    public static void update(int arr[],int size){
        for(int i=0;i<size;i++){
            if(arr[i]%2==0){
                arr[i]=2;
            }
        }
        System.out.println("The array in update function");
        display(arr, size);

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int size = sc.nextInt();
        System.out.println("Enter the elements of an array");
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array is ");
        display(arr, size);
        update(arr,size);
        System.out.println("The array outside update function in main function");
        display(arr, size);
        
    }
}
