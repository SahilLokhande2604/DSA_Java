import java.util.Scanner;

public class linearSearch {

    public static boolean isPresentUsingLinearSearch(int arr[],int key){

        return isPresent(arr,key,0);
    }
    public static boolean isPresent(int arr[],int key,int index){
        if(arr.length==0){
            return false;
        }
        if(index==(arr.length-1)){
            if(arr[index]==key){
                return true;
            }
            return false;
        }
        if(arr[index]==key){
            return true;
        }
        return isPresent(arr,key,++index);
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
        System.out.println("Enter the key to search in the array ");
        int key=sc.nextInt();
        boolean flag=isPresentUsingLinearSearch(arr, key);
        System.out.println("The key "+key+" is present in array "+flag);
    }
}
