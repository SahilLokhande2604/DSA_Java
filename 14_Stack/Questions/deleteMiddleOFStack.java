import java.util.*;

public class deleteMiddleOFStack {
    public void deleteMiddle(Stack<Integer>stack,int count,int size){
        if(count==size/2){
            
            System.out.println("Deleted element is "+stack.pop());
            return;
        }
        int num=stack.pop();
        deleteMiddle(stack, count+1, size);
        stack.push(num);

    }
    public void display(Stack<Integer>stack){
        if(stack.size()==0){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("--------");
        for(int i=0;i<stack.size();i++){
            System.out.println("|  "+stack.get(i)+"  |");
        }
        System.out.println("--------");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Stack<Integer>stack=new Stack<>();
        System.out.println("Enter the size of stack");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            stack.push(i);
        }

        deleteMiddleOFStack dm=new deleteMiddleOFStack();
        System.out.println("Stack is ");
        dm.display(stack);
        dm.deleteMiddle(stack,0,stack.size());
        
        System.out.println("After Deletion Stack is ");
        dm.display(stack);
    }
}
