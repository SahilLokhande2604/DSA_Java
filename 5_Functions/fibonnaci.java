package Functions;
import java.util.*;
public class fibonnaci{

    public static int fibo(int index){
        int num=0;
        int num2=1;
        if(index==1){
            return 0;
        }
        else if(index==2){
            return 1;
        }
        else{
            int i=2;
            while(i<=index){
                int temp=num2;
                num2=num+num2;
                num=temp;
                i++;
                // System.out.print(num2+" ");
            }
            return num;
        }

        // return num;
    }

    public static void dummy(int num){
        num++;
        System.out.println("The value of num in dummy is "+num);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the value of n to get the nth fibonnaci term");
        n=sc.nextInt();
        int ans=fibo(n);
        System.out.println("The "+n+"th term of fibonnaci series is "+ans);


        dummy(n);
        System.out.println("The value of n is "+n);
    }
}