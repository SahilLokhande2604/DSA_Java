import java.util.Scanner;

public class powfastest {

    public static int power(int a,int b){
        int result=1;
        while(b>0){
            if((b & 1)==1){
                result=result*a;
            }
            a=a*a;
            b=b>>1;
        }

        return result;
    }
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 numbers to find power of a^b");
        System.out.print("a: ");
        int num1=sc.nextInt();
        System.out.print("\nb: ");
        int num2=sc.nextInt();
        int ans=power(num1,num2);
        System.out.println("The power of "+num1+"^"+num2+" is "+ans);

     }
}
