import java.util.*;
public class insertElementAtBottomOfStack {
    public void insertAtBottom(Stack<Integer>stack,int num){
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }
        int curr=stack.pop();
        insertAtBottom(stack, num);
        stack.push(curr);
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
        insertElementAtBottomOfStack stk=new insertElementAtBottomOfStack();
        System.out.println("Enter the size of stack");
        int size=sc.nextInt();
        Stack<Integer>stack=new Stack<>();
        for(int i=1;i<=size;i++){
            stack.push(i);
        }
        System.out.println("Enter the element to add at bottom");
        int element=sc.nextInt();
        stk.display(stack);
        stk.insertAtBottom(stack, element);
        stk.display(stack);


    }
}
