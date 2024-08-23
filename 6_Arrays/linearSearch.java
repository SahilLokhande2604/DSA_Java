import java.util.*;
public class linearSearch {

    public static boolean isPresent(int arr[],int size,int key){
        boolean flag=false;
        for(int i=0;i<size;i++){
            if(arr[i]==key){
                flag=true;
                return flag;
            }
        }
        return flag;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int size=sc.nextInt();
        System.out.println("Enter the elements of an array");
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the element to check whether it is present in the array or not");
        int key=sc.nextInt();

        boolean flag=isPresent(arr, size, key);
        String present="";
        if(flag!=true){
            present="not";
        }
        System.out.println("The element "+key+" is "+present+" present in array ");
    }
}
