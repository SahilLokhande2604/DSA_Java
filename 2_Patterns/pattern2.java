//you want to print the below pattern 
//given that the total no. of rows are n=3;
//1 1 1 
//2 2 2 
//3 3 3 

import java.util.*;

public class pattern2 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the total no. of rows ");
        n=sc.nextInt();
        int i=1;
        while(i<=n){
            int j=1;
            while(j<=n){
                System.out.print(i+" ");
                j++;
            }
            i++;
            System.out.println();
        }
    }

    
}