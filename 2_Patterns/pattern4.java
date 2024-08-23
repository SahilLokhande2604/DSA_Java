//you want to print the below pattern 
//given that the total no. of rows are n=3;
//3 2 1 
//3 2 1 
//3 2 1 

import java.util.*;

public class pattern4 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the total no. of rows ");
        n=sc.nextInt();
        int i=1;
        while(i<=n){
            int j=n;
            while(j>0){
                System.out.print(j+" ");
                j--;
            }
            i++;
            System.out.println();
        }
    }

    
}


