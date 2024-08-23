import java.util.*;
public class maxStack {
    maxStack top;
    int data;
    maxStack next;
    int maxData;

    maxStack(){
        top=null;
    }

    public void push(int data){
        maxStack node =new maxStack();
        node.data=data;
        node.maxData=data;
        if(top==null){
            node.maxData=data;
            top=node;
            return;
        }
        
        node.maxData=Math.max(node.maxData,top.maxData);
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

    public int getMaxElement(){
        if(top==null){
            return -1;
        }
        return top.maxData;
    }

    public void display(){
        if(top==null){
            System.err.println("Stack is empty");
            return;
        }
        System.out.println("Stack is ");
        maxStack node=top;
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }

    }
    public static void main(String[] args) {
        maxStack stack=new maxStack();
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
                    int maxVal=stack.getMaxElement();
                    if(maxVal==-1){
                        System.out.println("Stack is Empty");
                    }
                    else{
                        System.out.println("Max. element in stack is "+maxVal);
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
