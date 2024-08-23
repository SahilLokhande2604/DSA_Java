//you want to print the below pattern 
//given that the total no. of rows are n=3;
//1 2 3
//4 5 6
//7 8 9

import java.util.*;

public class pattern5 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the total no. of rows ");
        n=sc.nextInt();
        int i=1;
        int count=1;
        while(i<=n){
            int j=1;
            while(j<=n){
                System.out.print(count+" ");
                j++;
                count++;
            }
            i++;
            System.out.println();
        }
        
    }
    
}



