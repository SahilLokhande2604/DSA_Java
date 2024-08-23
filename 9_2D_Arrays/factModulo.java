import java.util.Scanner;

public class factModulo {
    public static int factorial(int n){
        int fact=1;
        while(n>=1){
            fact=((fact*n)%1000000007);
            n--;
        }

        return fact;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to get its factorial");
        System.out.print("a: ");
        int num1=sc.nextInt();
        int ans=factorial(num1);
        System.out.println("The factorial of "+num1+" is "+ans);
    }
}
