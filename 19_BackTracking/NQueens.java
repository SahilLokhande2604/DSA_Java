import java.util.*;

public class NQueens {

    private void saveBoardInAns(List<List<Integer>>ans, int[][] board){
        List<Integer>temp=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){ 
                temp.add(board[i][j]);
            }
        }
        ans.add(temp);
    }

    private boolean isSafe(int row, int col, int[][] board, int n){
        
        int x=row;
        int y=col;

        // check for same row
        while(y>=0){
            if(board[x][y]==1){
                return false;
            }
            y--;
        }

        // check for diagonal 
        x=row;
        y=col;
        while(x>=0 && y>=0){
            if(board[x][y]==1){
                return false;
            }
            x--;
            y--;
        }

        x=row;
        y=col;

        while(x<n && y>=0){
            if(board[x][y]==1){
                return false;
            }
            x++;
            y--;
        }

        return true;
    }

    private boolean isSafeOptimize(int row, int col, Map<Integer,Boolean>rowCheck, Map<Integer,Boolean>upperDiagonal, Map<Integer,Boolean>lowerDiagonal, int n){
        if(rowCheck.containsKey(row)){
            if(rowCheck.get(row)==true){
               return false; 
            }
        }

        if(upperDiagonal.containsKey(row+col)){
            if(upperDiagonal.get(row+col)==true){
                return false;
            }
        }

        if(lowerDiagonal.containsKey(n-1+col-row)){
            if(lowerDiagonal.get(n-1+col-row)==true){
                return false;
            }
        }

        return true;
    }

    private void solve(int col, int[][] board, List<List<Integer>>ans, int n, Map<Integer,Boolean>rowCheck, Map<Integer,Boolean>upperDiagonal, Map<Integer,Boolean>lowerDiagonal){
        if(col==n){
            saveBoardInAns(ans, board);
            return;
        }

        for(int row=0;row<n;row++){
            // if(isSafe(row, col, board, n)){
            //     board[row][col]=1;
            //     solve(col+1, board, ans, n, rowCheck, upperDiagonal, lowerDiagonal);
            //     // backtrack
            //     board[row][col]=0;
            // }

            if(isSafeOptimize(row, col, rowCheck, upperDiagonal, lowerDiagonal, n)){
                board[row][col]=1;
                rowCheck.put(row,true);
                upperDiagonal.put(row+col, true);
                lowerDiagonal.put(n-1+col-row, true);
                solve(col+1, board, ans, n, rowCheck, upperDiagonal, lowerDiagonal);
                // backtrack
                board[row][col]=0;
                rowCheck.put(row,false);
                upperDiagonal.put(row+col, false);
                lowerDiagonal.put(n-1+col-row, false);
            }
        }

    }

    public List<List<Integer>>  nQueens(int n){
        int[][] board=new int[n][n];

        List<List<Integer>>ans=new ArrayList<>();
        Map<Integer,Boolean>rowCheck=new HashMap<>();
        Map<Integer,Boolean>upperDiagonal=new HashMap<>();
        Map<Integer,Boolean>lowerDiagonal=new HashMap<>();

        solve(0, board, ans, n, rowCheck, upperDiagonal, lowerDiagonal);

        return ans;
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of queens to place ");
        int n=sc.nextInt();


        NQueens nq=new NQueens();

        List<List<Integer>> ans= nq.nQueens(n);
        for(int i=0;i<ans.size();i++){
            List<Integer>board=ans.get(i);
            for(int j=0;j<board.size();){
                for(int k=0;k<n;k++){
                    System.out.print(board.get(j)+" ");
                    j++;
                }
                System.out.println();
            }
            System.out.println("---------------------------");
        }

    }
}
