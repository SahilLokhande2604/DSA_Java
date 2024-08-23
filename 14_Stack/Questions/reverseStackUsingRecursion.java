import java.util.*;
public class reverseStackUsingRecursion {

    private void addAtBottom(Stack<Integer>stack,int num){
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }
        int curr=stack.pop();
        addAtBottom(stack, num);
        stack.push(curr);
    }

    public void reverseStack(Stack<Integer>stack){
        if(stack.isEmpty()){
            return;
        }
        int curr=stack.pop();
        reverseStack(stack);
        addAtBottom(stack,curr);

    }


    public void display(Stack<Integer>stack){
        if(stack.size()==0){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("--------");
        for(int i=stack.size()-1;i>=0;i--){
            System.out.println("|  "+stack.get(i)+"  |");
        }
        System.out.println("--------");

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of stack");
        int size=sc.nextInt();
        Stack<Integer>stack=new Stack<>();
        for(int i=1;i<=size;i++){
            stack.push(i);
        }
        reverseStackUsingRecursion rS=new reverseStackUsingRecursion();
        rS.display(stack);
        rS.reverseStack(stack);
        rS.display(stack);



    }
}
