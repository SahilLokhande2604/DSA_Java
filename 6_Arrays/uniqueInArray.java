// Find the unique element from the given array of size n where n=(2*m+1) where the array conatins m elements twice and one single element which is unique 
// e.x. array={2,3,1,6,3,6,2}
import java.util.*;
public class uniqueInArray {

    public static void display(int arr[], int size) {
        System.out.println();
        for (int i = 0; i < size; i++) {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println();
     
    }

    public static int findUnique(int arr[],int size){
        int unique=-1;
        for(int i=0;i<size;i++){
            // unique=arr[i];
            boolean flag=false;
            if(arr[i]==Integer.MIN_VALUE){
                continue;
            }
            else{
                unique=arr[i];
            }
            for(int j=i+1;j<size;j++){
                if(arr[i]==arr[j]){
                    arr[j]=Integer.MIN_VALUE;
                    flag=true;
                    // break;
                }
               
            }
            if(flag){
                unique=-1;
            }
            else{
                return unique;
            }

        }



        return unique;
    }

    // This approach is good compare to above but only working when numbers are occuring atmost twice
    public static int findUnique2(int arr[],int size){
        int unique=0;
        for(int i=0;i<size;i++){
            unique=unique^arr[i];
            // System.out.println(unique+" ");
        }
        System.out.println("\n");
        return unique;
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
        int unique=findUnique(arr, size);
        System.out.println("The unique element is "+unique);
        // unique=findUnique2(arr, size);
        // System.out.println("The unique element is "+unique);

    }
}
