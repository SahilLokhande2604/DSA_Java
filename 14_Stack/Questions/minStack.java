import java.util.*;
public class minStack {
    minStack top;
    int data;
    minStack next;
    int minData;

    minStack(){
        top=null;
    }

    public void push(int data){
        minStack node =new minStack();
        node.data=data;
        node.minData=data;
        if(top==null){
            node.minData=data;
            top=node;
            return;
        }
        
        node.minData=Math.min(node.minData,top.minData);
        node.next=top;
        top=node;
        
    }

    public int pop(){
        if(top==null){
            return -1;
        }
        int data=top.data;
        top=top.next;
        return data;
    }

    public int getMinElement(){
        if(top==null){
            return -1;
        }
        return top.minData;
    }

    public void display(){
        if(top==null){
            System.err.println("Stack is empty");
            return;
        }
        System.out.println("Stack is ");
        minStack node=top;
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }

    }
    public static void main(String[] args) {
        minStack stack=new minStack();
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag){
            System.out.println("To push enter 1 \nto pop enter 2 \nto display enter 3 \nto get min. element from stack enter 4 \nto exit enter 0");
            int n=sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter the data to push into stack (positive values only)");
                    int data=sc.nextInt();
                    stack.push(data);
                    break;
                
                case 2:
                    int poppedData=stack.pop();
                    if(poppedData==-1){
                        System.out.println("Stack is Empty");
                    }
                    else{
                        System.out.println("Popped data is "+poppedData);
                    }
                    break;

                case 3:
                    stack.display();
                    break;
                
                case 4:
                    int minVal=stack.getMinElement();
                    if(minVal==-1){
                        System.out.println("Stack is Empty");
                    }
                    else{
                        System.out.println("Min. element in stack is "+minVal);
                    }
                    break;
                
                case 0:
                    flag=false;
                    break;
            
                default:
                System.out.println("Please enter valid data");
                    break;
            }
        }
        
    }
}
