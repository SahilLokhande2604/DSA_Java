import java.util.Scanner;
import java.util.Stack;

public class checkRedundentBracket {

    public boolean isRedundent(String s){
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/'){
                stack.push(s.charAt(i));
            }
            else{
                
                if(s.charAt(i)==')'){
                    boolean redundent=true;
                    while(stack.peek()!='('){
                        char curr=stack.pop();
                        if(curr=='+' || curr=='-' || curr=='*' || curr=='/'){
                            redundent=false;  // denotes that the current sub expression does not content redundent brackets
                        }
                    }
                    if(redundent==true){ // redundent brackets are present
                        return true;
                    }
                    stack.pop(); //remove the '(' from the stack
                }

            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        checkRedundentBracket cR=new checkRedundentBracket();
        System.out.println("Enter the valid expression");
        String expression=sc.nextLine();
        System.out.println("Expression contains redundent brackets."+cR.isRedundent(expression));
        


    }
}
