// Time Complexity: O(9^m)
// Space Complexity: O(1) = O(9*9)

import java.util.*;
public class SudokuSolver {

    private boolean isSafe(int row, int col, int[][] board, int val){

        for(int i=0;i<9;i++){
            // check for row
            if(board[row][i]==val){
                return false;
            }
            // check for column
            if(board[i][col]==val){
                return false;
            }

            // check for 3*3 board
            int r=3*(row/3) + (i/3);
            int c=3*(col/3) + (i%3);

            if(board[r][c]==val){
                return false;
            }

        }
        return true;
    }

    private boolean solve(int[][] board){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    for(int val=1;val<=9;val++){
                        if(isSafe(i, j, board, val)){
                            board[i][j]=val;
                            boolean furtherSolutionPossible=solve(board);
                            if(furtherSolutionPossible){
                                return true;
                            }
                            else{
                                board[i][j]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void sudokuSolver(int[][] sudoku){
        solve(sudoku);
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);

        int[][] sudoku=new int[9][9];

        SudokuSolver ss=new SudokuSolver();
        ss.sudokuSolver(sudoku);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
}
