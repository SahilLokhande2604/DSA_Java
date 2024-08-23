import java.util.*;
public class what_is_array{

    public static void display_int_array(int arr[]){
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        //Declaration of  an array
        int arr[]=new int[5];
        //here arr is the array name which is of integer type and of size 5 is declare

        // Another type to declare and initialze the array
        int num[]={1,6,9};

        System.out.println("The array with name arr is as below");
        display_int_array(arr);
        System.out.println("The size of array with name arr is "+arr.length);
        System.out.println("The array with name num is as below");
        display_int_array(num);
        System.out.println("The size of array with name num is "+num.length);

        


        
    }
}