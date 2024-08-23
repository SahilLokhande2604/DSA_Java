import java.util.Scanner;

public class power {
    public static int powerFunction(int a,int b){
        if(b==0){
            return 1;
        }
        return a*powerFunction(a, b-1);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of a and b to get a^b");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int ans=powerFunction(a,b);
        System.out.println(a+"^"+b+" = "+ans);

    }
}
