import java.util.Scanner;

public class reverseString {

    public static String reverseCharArray(char ch[],int start,int end){
        if(start>=end || ch.length==0){
            return new String(ch);
        }
        char temp=ch[start];
        ch[start]=ch[end];
        ch[end]=temp;
        reverseCharArray(ch, ++start, --end);

        return new String(ch);
    }

    public static String reverse(String s){
        char[] ch=s.toCharArray();

        return reverseCharArray(ch,0,ch.length-1);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string to reverse");
        String s=sc.nextLine();
        String ans=reverse(s);
        System.out.println(ans);
    }
}
