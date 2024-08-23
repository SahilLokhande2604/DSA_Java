import java.util.*;
public class largestRectangularAreaInBinarymatrix {

    private int[] previous(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<arr.length;i++){
            if(stack.peek()!=-1 && arr[stack.peek()]<arr[i]){
                ans[i]=stack.peek();
                stack.push(i);
            }
            else{
                while(stack.peek()!=-1 && arr[stack.peek()]>=arr[i]){
                    stack.pop();
                }
                ans[i]=stack.peek();
                stack.push(i);
            }
        }
        return ans;
    }

    private int[] next(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        for(int i=arr.length-1;i>=0;i--){
            if(stack.peek()!=-1 && arr[stack.peek()]<arr[i]){
                ans[i]=stack.peek();
                stack.push(i);
            }
            else{
                while(stack.peek()!=-1 && arr[stack.peek()]>=arr[i]){
                    stack.pop();
                }
                ans[i]=stack.peek();
                stack.push(i);
            }
        }
        return ans;
    }

    private int maxAreaOfRow(int[] arr){
        int area=-1;
        int[] previous=previous(arr);
        int[] next=next(arr);
        for(int i=0;i<arr.length;i++){
            int length=arr[i];
            if(next[i]==-1){
                next[i]=previous.length;
            }
            int breadth=next[i]-previous[i]-1;
            area=Math.max(area,length*breadth);
        }
        return area;
    }

    

    public int maxArea(int[][] matrix){
        int area=maxAreaOfRow(matrix[0]);
        // System.out.println(area);
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]!=0){
                    matrix[i][j]=matrix[i][j]+matrix[i-1][j];
                }
                else{
                    matrix[i][j]=0;
                }
            }
            area=Math.max(area,maxAreaOfRow(matrix[i]));
        }

        
        return area;
    }

    public void display(int[][] matrix){
        System.out.println("Matrix is");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the no. of rows and cols of matrix");
    int row=sc.nextInt();
    int col=sc.nextInt();
    int[][] matrix=new int[row][col];
    System.out.println("Enter values in binary matrix ");
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            matrix[i][j]=sc.nextInt();
        }
    }
    largestRectangularAreaInBinarymatrix area=new largestRectangularAreaInBinarymatrix();
    area.display(matrix);
    System.out.println("Largest rectangular area in binary matrix is "+area.maxArea(matrix));
    }
}
