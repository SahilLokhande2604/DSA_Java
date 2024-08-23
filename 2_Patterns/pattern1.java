//you are given 'n' total no. of rows ,you want to print n rows such that in each row there are n *;
//n=3;
//***
//***
//***
import java.util.*;
public class pattern1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the total no. of rows ");
        n=sc.nextInt();
        int i=1;
        while(i<=n){
            int j=1;
            while(j<=n){
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
