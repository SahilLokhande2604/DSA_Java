import java.util.*;
public class whatis2DArray{

    public static void rowSum(int arr[][]){
        System.out.println("The sum of elements of each row is");
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<arr[0].length;j++){
                sum=sum+arr[i][j];
            }
            System.out.print(sum+"|");
        }
        System.out.println("\n");
    }

    public static void colSum(int arr[][]){
        System.out.println("The sum of elements of each column is");
        for(int i=0;i<arr[0].length;i++){
            int sum=0;
            for(int j=0;j<arr.length;j++){
                sum=sum+arr[j][i];
            }
            System.out.print(sum+"|");
        }
        System.out.println("\n");
    }

    public static boolean find(int arr[][],int key){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==key){
                    return true;
                }
            }
        }
        return false;
    }

    public static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            // System.out.println("________");
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+"|");
            }
            System.out.println();
            // System.out.println("________");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of rows and no. of columns in the 2D matrix");
        int row=sc.nextInt();
        int col=sc.nextInt();
        int arr[][]=new int[row][col];
        System.out.println("Enter the elements row wise");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        display(arr);
        System.out.println();
        System.out.println("Enter the no. of rows and no. of columns in the 2D matrix");
        
        row=sc.nextInt();
        col=sc.nextInt();
        int arr2[][]=new int[row][col];
        System.out.println("Enter the elements column wise");
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                arr2[j][i]=sc.nextInt();
            }
        }
        display(arr2);
        System.out.println("Enter the key to find in the below array");
        display(arr);
        int key=sc.nextInt();
        boolean flag=find(arr, key);
        if(flag){
        System.out.println("The key is present ");
        }
        else{
            System.out.println("The key is absent ");
        }
        System.out.println("\nThe row and column element's sum of below array is ");
        display(arr);
        rowSum(arr);
        colSum(arr);


    }
}