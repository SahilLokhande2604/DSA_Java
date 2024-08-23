import java.util.*;

public class countPrime {

    public static void countPrime(int n){
        List<Integer>ans=new ArrayList<>();
        boolean count[]=new boolean[n+1];
        for(int i=0;i<count.length;i++){
            count[i]=true;
        }
        count[0]=false;
        count[1]=false;
        int cnt=0;
        for(int i=2;i<=n;i++){
            if(count[i]){
                cnt++;
                ans.add(i);
            }
            for(int j=i*2;j<=n;j=j+i){
                count[j]=false;
            }
        }
        System.out.println("Thus total no. of prime numbers from 1 to "+n+" are: "+cnt);
        System.out.println("Prime numbers from 1 to "+n+" are ");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }


    }
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of 'n' to print all digits which are prime from 1 to n ");
        int n=sc.nextInt();
        countPrime(n);

     }
}
