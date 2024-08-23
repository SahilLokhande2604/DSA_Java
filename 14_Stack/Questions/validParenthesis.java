import java.util.*;
public class validParenthesis {

    public boolean isValid(String s){
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr=='(' || curr=='{' || curr=='['){
                stack.push(curr);
            }
            else{
                if(!stack.isEmpty() && stack.peek()=='(' && curr==')'){
                    stack.pop();
                }
                else if(!stack.isEmpty() && stack.peek()=='{' && curr=='}'){
                    stack.pop();
                }
                else if(!stack.isEmpty() && stack.peek()=='[' && curr==']'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }

        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string of parentheses ('(',')','{','}','[',']')");
        HashSet<Character>set=new HashSet<>();
        set.add('(');
        set.add(')');
        set.add('{');
        set.add('}');
        set.add('[');
        set.add(']');
        String s=sc.nextLine();
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                System.out.println("Invalid Expression");
                flag=false;
                break;
            }
        }
        validParenthesis vp=new validParenthesis();
        if(flag){
            System.out.println("Input parentheses is valid? "+vp.isValid(s));
        }

    }
}
