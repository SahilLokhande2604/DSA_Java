import java.util.ArrayList;
import java.util.*;

public class subSets {

    public static void subsets(int arr[],int n){
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        ArrayList<Integer>output=new ArrayList<>();

        int index=0;

        solve(arr,output,ans,index);

        System.out.print("[ ");
        for (ArrayList<Integer> subset : ans) {
            System.out.print("[ ");
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.print("], ");
        }
        System.out.println(" ]\n");


    }

    public static void solve(int arr[],ArrayList<Integer>output,ArrayList<ArrayList<Integer>> ans,int index){

        if(index>=arr.length){
            ans.add(output);
            return;
        }

        // exclude
        solve(arr, new ArrayList<>(output), ans, index+1);

        int element=arr[index];
        output.add(element);
        solve(arr, new ArrayList<>(output), ans, index+1);

    }


    public static void display(int arr[],int start,int end){
        for(int i=0;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
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
        display(arr,0,arr.length-1);
        subsets(arr, size);
        
    }
}
