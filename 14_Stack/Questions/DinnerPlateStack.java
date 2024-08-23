import java.util.*;
public class DinnerPlateStack {
    ArrayList<Stack<Integer>>arr=new ArrayList<>();
    int maxStackSize;
    int currIndex=0;
    

    DinnerPlateStack(int capacity){
        maxStackSize=capacity;
    }

    public void push(int val){
        if(arr.size()==0){
            Stack<Integer>stack=new Stack<>();
            stack.push(val);
            arr.add(currIndex, stack);
            return;
        }
        if(arr.get(currIndex).size()==maxStackSize){
            Stack<Integer>stack=new Stack<>();
            stack.push(val);
            currIndex++;
            arr.add(currIndex,stack);
            return;    
        }
        arr.get(currIndex).push(val);
    }

    public int pop(){
        if(arr.size()==0 || arr.get(currIndex).isEmpty()){
            return -1;
        }
        int data=arr.get(currIndex).pop();
        if(arr.get(currIndex).isEmpty()){
            currIndex--;
            if(currIndex<0){
                currIndex=0;
            }
        }
        return data;
    }

    public int popAtIndex(int index){
        if(index>currIndex || arr.size()==0 || arr.get(index).isEmpty()){
            return -1;
        }
        int data=arr.get(index).pop();
        if(arr.get(index).isEmpty()){
            for(int i=index;i<arr.size()-1;i++){
                arr.set(i,arr.get(i+1));
            }
        }
        return data;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DinnerPlateStack dinner = new DinnerPlateStack(2);
        System.out.println("Perform below operations");
        boolean flag=true;
        while(flag){
            System.out.println("Enter 1 to push, enter 2 to pop, enter 3 to pop at specific stack,enter 0 to exit");
            int n=sc.nextInt();

            switch(n){
                case 1:
                    System.out.println("Enter the data to push");
                    int val=sc.nextInt();
                    dinner.push(val);
                    break;
                
                case 2:
                    System.out.println("Popped data is "+dinner.pop());
                    break;
                
                case 3:
                    System.out.println("Enter the stack no. to pop elemnt from it");
                    int index=sc.nextInt();
                    System.out.println("Popped data is "+dinner.popAtIndex(index));
                    break;
                
                case 0:
                    flag=false;
                    break;
                
                default:
                    System.out.println("Please enter valis input");
                    break;

            }
        }
    }
}


// pushing at leftmost stack when pushing is possible is not implemented in above code;