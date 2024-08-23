import java.util.Scanner;

public class waveOutput {

    public static void displayWave(int arr[][]){
        for(int i=0;i<arr[0].length;i++){
            if(i%2==0){
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr[j][i]+" ");
                }
            }
            else{
                for(int j=arr.length-1;j>=0;j--){
                    System.out.print(arr[j][i]+" ");
                }
            }
            
        }
        System.out.println();
    }




    public static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "|");
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
        displayWave(arr);
    }
}
