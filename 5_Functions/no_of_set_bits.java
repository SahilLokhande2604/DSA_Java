package Functions;
import java.util.*;
public class no_of_set_bits {

    public static int count_set_bits(int num){
        int count=0;
        while(num!=0){
            if((num & 1)==1){
                count++;
            }
           num = num >> 1;
        }
        return count;
    }

    public static int total_set_bits(int num1,int num2){
        int count=0;
        count=count+count_set_bits(num1)+count_set_bits(num2);
        return count;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n1,n2;
        System.out.println("Enter the first number");
        n1=sc.nextInt();
        System.out.println("Enter the second number");
        n2=sc.nextInt();
        int ans=total_set_bits(n1, n2);
        System.out.println("The total no. of set bits in "+n1+" and "+n2+" are: "+ans);
    }
}
