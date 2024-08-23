import java.util.Scanner;

public class palindrome {
    public static boolean checkPalindrome(String s){
        char[] ch=s.toCharArray();
        return check(ch,0,ch.length-1);
    }

    public static boolean check(char ch[],int start,int end){
        if(start>end || ch.length==0){
            return true;
        }
        if(ch[start]!=ch[end]){
           return false;
            
        }
        return check(ch, ++start, --end);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string to check whether it is palindrome or not");
        String s=sc.nextLine();
        boolean ans=checkPalindrome(s);
        System.out.println(ans);
    }
}
