import java.util.*;
public class swapAlternate {

    public static void display(int arr[], int size) {
        System.out.println();
        for (int i = 0; i < size; i++) {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println();
     
    }

    public static int[] swapAlter(int arr[],int size){
        int first=0;
        int second=first+1;
        while(first<size){
            if(second>=size){
                second=first;
            }
            int temp=arr[first];
            arr[first]=arr[second];
            arr[second]=temp;
            first=second+1;
            second=first+1;
        }
        return arr;
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag){
        System.out.println("Enter the size of the array");
        int size=sc.nextInt();
    
        System.out.println("Enter the elements in the array");
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("The array before swaping is");
        display(arr,size);
        System.out.println("The array after swaping is");
        int ans[]=swapAlter(arr, size);
        display(ans, size);

        System.out.println("To continue enter 1 else any number");
        int n=sc.nextInt();
        if(n!=1){
            flag=false;
        }
    }
    }
}
