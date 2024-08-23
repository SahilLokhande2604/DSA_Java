import java.util.Scanner;

public class climbStairs {

    public static int climb(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        int count=climb(n-1)+climb(n-2);
        return count;
    }

     public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of 'n' to get the possible combination to reach nth stair");
        int n=sc.nextInt();
        int ans=climb(n);
        System.out.println("The possible combination are "+ans);
       
     }
}
