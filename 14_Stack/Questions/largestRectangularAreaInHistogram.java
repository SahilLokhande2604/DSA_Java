import java.util.*;

public class largestRectangularAreaInHistogram {

    private int[] previousSmallerElement(int[] heights){
        int[] ans=new int[heights.length];
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<heights.length;i++){
            if(stack.peek()!=-1 && heights[stack.peek()] < heights[i] ){
                ans[i]=stack.peek();
                stack.push(i);
            }
            else{
                while(stack.peek()!=-1 && heights[stack.peek()]>heights[i]){
                    stack.pop();
                }
                ans[i]=stack.peek();
                stack.push(i);

            }
        }
        return ans;
    }

    private int[] nextSmallerElement(int[] heights){
        int[] ans=new int[heights.length];
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        for(int i=heights.length-1;i>=0;i--){
            if(stack.peek()!=-1 && heights[stack.peek()] < heights[i] ){
                ans[i]=stack.peek();
                stack.push(i);
            }
            else{
                while(stack.peek()!=-1 && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                ans[i]=stack.peek();
                stack.push(i);

            }
        }
        return ans;
    }

    public int largestRectangularArea(int[] heights){
        int maxArea=Integer.MIN_VALUE;
        int[] previous=previousSmallerElement(heights);
        int[] next=nextSmallerElement(heights);
        for(int i=0;i<heights.length;i++){
            int length=heights[i];
            if(next[i]==-1){
                next[i]=heights.length;
            }
            int breadth=next[i]-previous[i]-1;
            maxArea=Math.max(maxArea,(length*breadth));
        }
        return maxArea;

    }
    public void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of histogram");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the heights of bars in histogram");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        largestRectangularAreaInHistogram rectangle=new largestRectangularAreaInHistogram();
        System.out.println("Histogram is ");
        rectangle.display(arr);
        System.out.println("Largest Rectangular area in histogram is "+rectangle.largestRectangularArea(arr));
        


    }
}
