import java.util.Scanner;

public class sayDigits {
    public static void say(int n){
        String digit[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};

        if(n==0){
            return;
        }
        int number=n%10;
        say(n/10);
        System.out.print(digit[number]+" ");
    }
     public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of digit");
        int n=sc.nextInt();
        say(n);
        
       
     }
}
