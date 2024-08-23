import java.util.Scanner;

public class fastPower {
    public static int power(int a,int b){
        return pow(a,b,1);

    }
    public static int pow(int a,int b,int ans){
        if(b<=0){
            return ans;
        }
        if((b&1)==1){
            ans=ans*a;
        }
        a=a*a;
        b=b>>1;
        return pow(a,b,ans);
    }

    public static int babbarSol(int a,int b){
        if(b==0){
            return 1;
        }
        if(b==1){
            return a;
        }
        int ans=babbarSol(a, b/2);
        if((b&1)==1){
            return a*ans*ans;
        }
        else{
            return ans*ans;
        }
    }



    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of a and b for a^b ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int ans=power(a, b);
        System.out.println("Power of "+a+"^"+b+" is "+ans);
        ans=babbarSol(a, b);
        System.out.println("Power of "+a+"^"+b+" is "+ans);

    }
}
