import java.util.*;

public class minCostToMakeStringValid {
    public int makeValid(String s){
        if(s.length()%2!=0){
            return -1;
        }
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && stack.peek()=='{' && s.charAt(i)=='}'){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        int openCount=0,closeCount=0;
        while(!stack.isEmpty()){
            char curr=stack.pop();
            if(curr=='{'){
                openCount++;
            }
            else{
                closeCount++;
            }
        }
        return (openCount+1)/2 + (closeCount+1)/2;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        minCostToMakeStringValid mC=new minCostToMakeStringValid();
        System.out.println("Enter the expression");
        String expression=sc.nextLine();
        System.out.println("Min. cost to make string valis is "+mC.makeValid(expression));
        
        


    }
}
