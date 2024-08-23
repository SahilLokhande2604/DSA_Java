import java.util.*;
public class nextSmallestElementInArray {
    public int[] nextSmallElement(int[] arr){
        int[] ans=new int[arr.length];

        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        for(int i=arr.length-1;i>=0;i--){
            if(stack.peek()<arr[i]){
                ans[i]=stack.peek();
                stack.push(arr[i]);
            }
            else{
                while(stack.peek()>=arr[i]){
                    stack.pop();
                }
                ans[i]=stack.peek();
                stack.push(arr[i]);
            }
        }
        return ans;
    }

    public void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in array(+ve elements only)");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        nextSmallestElementInArray nE=new nextSmallestElementInArray();
        nE.display(arr);
        System.out.println("Next smaller element for each element in array is as below");
        nE.display(nE.nextSmallElement(arr));


    }
}
