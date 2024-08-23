import java.util.*;
public class celebrityProblem {

    public int findCelebrity(int[][] people){
        Stack<Integer>stack=new Stack<>();
        int celebrity=-1;
        int n=people.length;
        for(int i=0;i<n;i++){
            stack.push(i);
        }
        while(!stack.isEmpty() && stack.size()!=1){
            int a=stack.pop();
            int b=stack.pop();
            if(people[a][b]==1 && people[b][a]==0){
                stack.push(b);
            }
            if(people[b][a]==1 && people[a][b]==0){
                stack.push(a);
            }

        }
        if(!stack.isEmpty()){
            celebrity=stack.pop();
        }
        else{
            return -1;
        }
        int countRow=0,countCol=0;
        for(int i=0;i<n;i++){
            if(people[celebrity][i]==0){
                countRow++;
            }
            if(people[i][celebrity]==1){
                countCol++;
            }
        }
        if(!(countCol==n-1 && countRow==n)){
            return -1;
        }
        return celebrity;
    }

    public void display(int[][] people){
        System.out.println("Array is ");
        for(int i=0;i<people.length;i++){
            for(int j=0;j<people[i].length;j++){
                System.out.print(people[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of people in party");
        int n=sc.nextInt();
        System.out.println("If ith person knows jth preson enter 1 at [i][j] else 0");
        int[][] people=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                people[i][j]=sc.nextInt();
            }
        }

        celebrityProblem cp=new celebrityProblem();
        cp.display(people);
        System.out.println("Celebrity is "+cp.findCelebrity(people));

    }
}
