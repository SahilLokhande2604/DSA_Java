import java.util.*;
public class charArray{

    public static boolean isPalindromeWithoutCaseSensitive(char ch[]){
        int start=0,end=ch.length-1;
        while(start<=end){
            if(ch[start]>='A' && ch[start]<='Z'){
                ch[start]=(char) (ch[start]+ 'A' - 'a');
            }
            if(ch[end]>='A' && ch[end]<='Z'){
                ch[end]=(char)(ch[end]- 'A' + 'a');
            }
            if(ch[start]!=ch[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome(char ch[]){
        int start=0;
        int end=ch.length-1;
        while(start<=end){
            if(ch[start]!=ch[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void reverseCharArray(char ch[]){
        int start=0;
        int end=ch.length-1;
        while(start<=end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
        }
        display(ch);
    }

    public static void display(char ch[]){
        System.out.print("Your name is ");
        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]);
        }
        System.out.println("");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of your name");
        int n=sc.nextInt();
        char[] ch=new char[n];
        System.out.println("Enter your name character wise");
        for(int i=0;i<n;i++){
            ch[i]=sc.next().charAt(0);
        }
        display(ch);
        System.out.println("The reverse name is ");
        reverseCharArray(ch);

        System.out.print("Your name is palindrome. ");
        boolean flag=isPalindrome(ch);
        System.out.println(flag);
        System.out.print("Your name is palindrome without case sensitive ");
        flag=isPalindromeWithoutCaseSensitive(ch);
        System.out.println(flag);

    }
}