import java.util.*;
public class reverseStringUsingStack{
    public String reverseString(String s){
    Stack<Character>stack=new Stack<>();
    String ans="";
    for(int i=0;i<s.length();i++){
        stack.push(s.charAt(i));
    }
    while(!stack.isEmpty()){
        ans=ans+stack.pop();
    }
    return ans;
    }
    public static void main(String argd[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string to reverse");
        String s=sc.nextLine();
        reverseStringUsingStack rString=new reverseStringUsingStack();
        System.out.println(rString.reverseString(s));
    }
}