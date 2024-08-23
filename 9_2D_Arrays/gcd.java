import java.util.Scanner;

public class gcd {

    public static int GCD(int a,int b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        while(a!=b){
            if(a>b){
                a=a-b;
            }
            else{
                b=b-a;
            }
        }
        return a;

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 numbers to find GCD of them");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int gcdNo=GCD(num1,num2);
        System.out.println("The GCD of "+num1+" and "+num2+" is "+gcdNo);

     }
}
