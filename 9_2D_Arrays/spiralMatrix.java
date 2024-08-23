import java.util.Scanner;

public class spiralMatrix {

    public static void spiral(int arr[][]){
        
        int startRow=0;
        int endCol=arr[0].length-1;
        int endRow=arr.length-1;
        int startCol=0;
        int count=0;
        int total=arr.length*arr[0].length;
        int ans[]=new int[total];
        while(count<total){
            for(int i=startCol;count<total && i<=endCol;i++){
                ans[count++]=arr[startRow][i];
            }
            startRow++;

            for(int i=startRow;count<total && i<=endRow;i++){
                ans[count++]=arr[i][endCol];
            }
            endCol--;

            for(int i=endCol;count<total && i>=startCol;i--){
                ans[count++]=arr[endRow][i];
            }
            endRow--;

            for(int i=endRow;count<total && i>=startRow;i--){
                ans[count++]=arr[i][startCol];
            }
            startCol++;
        }

        displaySpiral(ans);

    }
    public static void displaySpiral(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

     public static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows and no. of columns in the 2D matrix");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int arr[][] = new int[row][col];
        System.out.println("Enter the elements row wise");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        display(arr);
        System.out.println();
        spiral(arr);
        
    }
}
