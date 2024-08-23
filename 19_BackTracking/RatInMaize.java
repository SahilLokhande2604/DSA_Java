import java.util.*;

public class RatInMaize{

    private boolean isSafe(int newx, int newy, int n, int[][] maize, boolean[][] visited){
        if((newx>=0 && newx<n) && (newy>=0 && newy<n) && (maize[newx][newy]==1 ) && (visited[newx][newy]==false)){
            return true;
        }
        return false;
    }

    private void solve(int x, int y, int[][] maize, int n, List<String>ans, boolean[][] visited, String path){
        if(x==n-1 && y==n-1){
            ans.add(path);
            return;
        }

        if(isSafe(x+1, y, n, maize, visited)){
            visited[x][y]=true;
            solve(x+1,y, maize, n, ans, visited, path+"D");
            visited[x][y]=false;
        }

        if(isSafe(x, y-1, n, maize, visited)){
            visited[x][y]=true;
            solve(x,y-1, maize, n, ans, visited, path+"L");
            visited[x][y]=false;
        }

        if(isSafe(x, y+1, n, maize, visited)){
            visited[x][y]=true;
            solve(x,y+1, maize, n, ans, visited, path+"R");
            visited[x][y]=false;
        }

        if(isSafe(x-1, y, n, maize, visited)){
            visited[x][y]=true;
            solve(x-1,y, maize, n, ans, visited, path+"U");
            visited[x][y]=false;
        }
    }

    public List<String> searchInMaize(int[][] maize, int n){
        List<String>ans=new ArrayList<>();
        boolean[][] visited=new boolean[n][n];

        int x=0;
        int y=0;
        String path="";
        if(maize[0][0]==0){
            return ans;
        }

        solve(x, y, maize, n, ans, visited, path);

        return ans;
    }

    public static void main(String a[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n (of n*n grid)");
        int n=sc.nextInt();
        System.out.println("Enter the values of each cell either 0 or 1 (0 for absent 1 for present)");
        int[][] grid=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }

        RatInMaize rat=new RatInMaize();
        List<String>ans=rat.searchInMaize(grid, n);
        System.out.println(ans);
    }
}