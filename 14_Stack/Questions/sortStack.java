import java.util.Scanner;
import java.util.Stack;

public class sortStack {

    private void insertAtCorrectLocation(Stack<Integer>stack,int num){
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }
        
        if(num<stack.peek()){
            int top=stack.pop();
            insertAtCorrectLocation(stack, num);
            stack.push(top);
        }
        else{
            stack.push(num);
        }
        
    }

    public void sort(Stack<Integer>stack){
        if(stack.isEmpty()){
            return;
        }
        int curr=stack.pop();
        sort(stack);
        insertAtCorrectLocation(stack,curr);
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
        sortStack ss=new sortStack();
        System.out.println("Enter the size of stack");
        int size=sc.nextInt();
        Stack<Integer>stack=new Stack<>();
        System.out.println("Enter the elements into stack");
        for(int i=0;i<size;i++){
            int num=sc.nextInt();
            stack.push(num);
        }
        
        ss.display(stack);
        ss.sort(stack);
        ss.display(stack);


    }
}
