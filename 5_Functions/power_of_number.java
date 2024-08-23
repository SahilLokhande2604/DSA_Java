package Functions;
import java.util.*;
// package Functions;
public class power_of_number {

    public static int calculate_power(int num,int power){
        int ans=1;
        for(int i=1;i<=power;i++){
            ans=ans*num;
        }
        return ans;
    }

    public static void main(String args[]){
        int a,b;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        a=sc.nextInt();
        System.out.println("Enter the power");
        b=sc.nextInt();

        //Call the function
        //as it returns an integer so we need to store it in an variable
        int solution=calculate_power(a, b);
        System.out.println("The value of "+a+"^"+b+"="+solution);
    }
}
