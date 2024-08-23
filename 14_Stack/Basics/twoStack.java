import java.util.*;
public class twoStack {
    int[] stack=new int[10];
    int index1=-1,index2=10;
    int size1=0,size2=0;

    public void push1(int data){
        if(index2>index1+1 && index1<stack.length){
            stack[++index1]=data;
            size1++;
            return;
        }
        else{
            System.out.println("Stack1 overflow");
        }
    }
    public int pop1(){
        if(index1<0){
            System.out.println("Stack1 is empty");
            return -1;
        }
        int data=stack[index1];
        stack[index1]=0;
        index1--;
        size1--;
        return data;

    }
    public int size1(){
        return size1;
    }
    public void display1(){
        if(index1<0){
            System.out.println("Stack1 is empty");
            return;
        }
        System.out.println("STACK 1");
        System.out.println("---------");
        for(int i=index1;i>=0;i--){
            System.out.println("|  "+stack[i]+"  |");
        }
        System.out.println("---------");
    }

    public void push2(int data){
        if(index2>index1+1 && index2>-1){
            stack[--index2]=data;
            size2++;
            return;
        }
        else{
            System.out.println("Stack2 overflow");
        }
    }

    public int pop2(){
        if(index2>=stack.length){
            System.out.println("Stack2 is empty");
            return -1;
        }
        int data=stack[index2];
        stack[index2++]=0;
        return data;
    }
    public int size2(){
        return size2;
    }
    public void display2(){
        if(index2>=stack.length){
            System.out.println("Stack2 is empty");
            return;
        }
        System.out.println("STACK 2");
        System.out.println("---------");
        for(int i=index2;i<stack.length;i++){
            System.out.println("|  "+stack[i]+"  |");
        }
        System.out.println("---------");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        twoStack stk=new twoStack();
        boolean flag=true;
        do{
            System.out.println("To push in stack 1 enter 1\nTo pop in stack 1 enter 2\nTo display stack 1 enter 3\nTo get size of stack 1 enter 4\n \n To push in stack 2 enter 5\nTo pop in stack 2 enter 6\nTo display stack 2 enter 7\nTo get size of stack 2 enter 8\n\nTo exit enter 0\n");
            int n=sc.nextInt();
            switch(n){
                case 1:
                System.out.println("Enter data to push in stack");
                int data=sc.nextInt();
                stk.push1(data);
                break;

                case 2:
                int popData=stk.pop1();
                if(popData==-1){
                    System.out.println("Stack is empty");
                    break;
                }
                System.out.println("Data "+popData+" popped successfully");
                break;

                case 3:
                stk.display1();
                break;

                case 4:
                System.out.println("Size="+stk.size1());
                break;

                case 5:
                System.out.println("Enter data to push in stack2");
                data=sc.nextInt();
                stk.push2(data);
                break;

                case 6:
                popData=stk.pop2();
                if(popData==-1){
                    System.out.println("Stack is empty");
                    break;
                }
                System.out.println("Data "+popData+" popped successfully");
                break;

                case 7:
                stk.display2();
                break;

                case 8:
                System.out.println("Size="+stk.size2());
                break;

                case 0:
                flag=false;
                break;

                default:
                System.out.println("Please enter valid key");
                break;
            }
        }
        while(flag);

    }
}
