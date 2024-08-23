import java.util.Scanner;

public class count {
    // head recursion
    // function{
    //     1) base case
    //     2) recursive function
    //     3) processing
    // }

    public static void headRecursionPrintCount(int n){
        if(n==0){
            return;
        }
        headRecursionPrintCount(n-1);
        System.out.print(n+" ");
    }


    // tail Recursion
     // function{
    //     1) base case
    //     2) processing
    //     3) recursive function
    // }

    public static void printCount(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        printCount(n-1);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to print its count from n to 1");
        int n=sc.nextInt();
        System.out.println("Tail Recursive Function");
        printCount(n);
        System.out.println("\nHead Recursive Function");
        headRecursionPrintCount(n);
        

    }
}
